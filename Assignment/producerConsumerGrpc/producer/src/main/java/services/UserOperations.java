package services;

import com.demo.grpc.User;
import com.demo.grpc.userGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.sql.*;
import java.util.logging.Logger;

import org.mindrot.jbcrypt.BCrypt;


public class UserOperations extends userGrpc.userImplBase {
    private static final Logger logger = Logger.getLogger(UserOperations.class.getName());

    @Override
    public void registerUser(User.RegisterNewUser request, StreamObserver<User.APIRes> responseObserver) {
        String username = request.getUsername();
        String passwordBase = request.getPassword();

        try {
            // check if the user already exists
            String hashedPassword = checkUsersExistence(username);

            if (hashedPassword != null) {
                // user already exists
                responseObserver.onNext(User.APIRes.newBuilder().setResponseStatus(400).setResponseMessage("User already exists!").build());
                logger.info(username + " already exists!\nPlease try login!");
                return;
            }
        } catch (Exception e){}


        // encrypting password
        String salt = BCrypt.gensalt();
        String password = BCrypt.hashpw(passwordBase, salt);

        // Insert user data into the MySQL database
        try (Connection connection = Database.getConnection()) {
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    // Registration successful
                    responseObserver.onNext(User.APIRes.newBuilder().setResponseStatus(200).setResponseMessage("Registration successful").build());
                } else {
                    // Registration failed
                    responseObserver.onNext(User.APIRes.newBuilder().setResponseStatus(400).setResponseMessage("Registration failed!").build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            responseObserver.onNext(User.APIRes.newBuilder().setResponseStatus(500).setResponseMessage("Internal server error").build());
        }

        responseObserver.onCompleted(); // this is to end the stream
    }

    // check a user's credentials. if the user exists, return the hashed password. if not, return null
    private String checkUsersExistence(String username) throws SQLException {
        // check if the user exists
        try (Connection connection = Database.getConnection()) {
            String getUserQuery = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(getUserQuery)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // user exists
                        return resultSet.getString("password");
                    }
                }
            }
        }

        return null;
    }

    @Override
    public void loginUser(User.LoginExistingUser request, StreamObserver<User.APIRes> responseObserver) {
        String username = request.getUsername();
        String passwordBase = request.getPassword();

        // Getting the hashed password from the database
        String storedHashedPassword = null;
        try {
            storedHashedPassword = checkUsersExistence(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        User.APIRes.Builder response = User.APIRes.newBuilder();

        // if the storedHashedPassword is not null it means that the user exists. now we check if the password matches
        if (storedHashedPassword != null) {
            if (BCrypt.checkpw(passwordBase, storedHashedPassword)) {
                // Password matches
                response.setResponseStatus(200).setResponseMessage("Success!");
                logger.info(username + " logged in successfully!");
            } else {
                // password does not match
                response.setResponseStatus(401).setResponseMessage("Unauthorized access!");
                logger.info(username + " does not match the password!\nPlease try again!");
            }
        } else {
            // user does not exist
            response.setResponseStatus(404).setResponseMessage("User does not exist!");
            logger.info(username + " does not exist!\nPlease register first!");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void setProfile(User.SetProfileInfo request, StreamObserver<User.APIRes> responseObserver) {
        String username = request.getUsername();
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String city = request.getCity();

        // write profiles table
        try (Connection connection = Database.getConnection()) {
            String insertQuery = "INSERT INTO profiles (username, firstName, lastName, email, city) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, city);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    // Profile set successful
                    responseObserver.onNext(User.APIRes.newBuilder().setResponseStatus(200).setResponseMessage("Profile set successfully!").build());
                } else {
                    // Profile set failed
                    responseObserver.onNext(User.APIRes.newBuilder().setResponseStatus(400).setResponseMessage("Profile set failed!").build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            responseObserver.onNext(User.APIRes.newBuilder().setResponseStatus(500).setResponseMessage("Internal server error").build());
        }

        responseObserver.onCompleted();
    }

    @Override
    public void userProfileView (User.ProfileReq request, StreamObserver<User.ProfileView> responseObserver) {
        String username = request.getUsername();
        String firstName = "";
        String lastName = "";
        String email = "";
        String city = "";

        // read profiles table
        try (Connection connection = Database.getConnection()) {
            String selectQuery = "SELECT firstName, lastName, email, city FROM profiles WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        firstName = resultSet.getString("firstName");
                        lastName = resultSet.getString("lastName");
                        email = resultSet.getString("email");
                        city = resultSet.getString("city");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the database error here
            responseObserver.onError(Status.INTERNAL.withDescription("Internal server error").asRuntimeException());
            return;
        }

        // Construct a ProfileRes message with the user's profile data
        User.ProfileView userProfileViewRes = User.ProfileView.newBuilder()
                .setUsername(username)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setCity(city)
                .build();

        responseObserver.onNext(userProfileViewRes);
        responseObserver.onCompleted();
    }

    @Override
    public void updateProfile(User.UpdateProfileInfo request, StreamObserver<User.APIRes> responseObserver) {
        String username = request.getUsername();
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String city = request.getCity();

        // Update the user's profile in the database based on the provided data
        try (Connection connection = Database.getConnection()) {
            String updateQuery = "UPDATE profiles SET firstName = ?, lastName = ?, email = ?, city = ? WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, city);
                preparedStatement.setString(5, username);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    // Profile update successful
                    User.APIRes updateResponse = User.APIRes.newBuilder()
                            .setResponseStatus(200)
                            .setResponseMessage("Profile updated successfully")
                            .build();
                    responseObserver.onNext(updateResponse);
                    logger.info("Profile update successful for user: " + username);
                } else {
                    // Profile update failed (user not found)
                    User.APIRes updateResponse = User.APIRes.newBuilder()
                            .setResponseStatus(404)
                            .setResponseMessage("User not found or profile update failed")
                            .build();
                    responseObserver.onNext(updateResponse);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the database error
            User.APIRes updateResponse = User.APIRes.newBuilder()
                    .setResponseStatus(500)  // Internal server error
                    .setResponseMessage("Internal server error")
                    .build();
            responseObserver.onNext(updateResponse);
        }

        responseObserver.onCompleted();
    }

}