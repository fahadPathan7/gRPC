package services;

import com.demo.grpc.User;
import com.demo.grpc.userGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.sql.*;
import java.util.logging.Logger;

import org.mindrot.jbcrypt.BCrypt;


public class UserService extends userGrpc.userImplBase {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Override
    public void login(User.LoginReq request, StreamObserver<User.APIRes> responseObserver) {
        String userName = request.getUsername();
        String password = request.getPassword();

        logger.info("Request generated from user: " + userName);

        // Retrieve the hashed password for the given username from the database
        String storedHashedPassword = getStoredPasswordFromDatabase(userName);

        User.APIRes.Builder response = User.APIRes.newBuilder();

        if (storedHashedPassword != null && BCrypt.checkpw(password, storedHashedPassword)) {
            // Password matches
            response.setResCode(200).setMessage("SUCCESS");
            logger.info("Login successful for user: " + userName);
        } else {
            // Invalid credentials
            response.setResCode(401).setMessage("Unauthorized");
            logger.info("Login failed for user: " + userName);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    // Helper method to retrieve the stored hashed password from the database
    private String getStoredPasswordFromDatabase(String username) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String selectQuery = "SELECT password FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("password");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if the username is not found
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIRes> responseObserver) {
        super.logout(request, responseObserver);
    }


    @Override
    public void register(User.RegisterReq request, StreamObserver<User.APIRes> responseObserver) {
        String username = request.getUsername();
        String passwordBase = request.getPassword();
        String email = request.getEmail();
        String bio = request.getBio();

        // hashing password
        String salt = BCrypt.gensalt();
        String password = BCrypt.hashpw(passwordBase, salt);

        logger.info("Registration Loading");

        // Insert user data into the MySQL database
        try (Connection connection = DatabaseConnector.getConnection()) {

            logger.info("Database Connection Running");
            String insertQuery = "INSERT INTO users (username, password, email, bio) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, bio);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    // Registration successful
                    responseObserver.onNext(User.APIRes.newBuilder().setResCode(200).setMessage("Registration successful").build());
                } else {
                    // Registration failed
                    responseObserver.onNext(User.APIRes.newBuilder().setResCode(400).setMessage("Registration failed").build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            responseObserver.onNext(User.APIRes.newBuilder().setResCode(500).setMessage("Internal server error").build());
        }

        responseObserver.onCompleted();
    }

    @Override
    public void getProfile(User.ProfileReq request, StreamObserver<User.ProfileRes> responseObserver) {
        String username = request.getUsername();
        String email = "";
        String bio = "";

        logger.info("Getting Data and Showing User Profile");

        try (Connection connection = DatabaseConnector.getConnection()) {
            String selectQuery = "SELECT email, bio FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        email = resultSet.getString("email");
                        bio = resultSet.getString("bio");
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
        User.ProfileRes profileRes = User.ProfileRes.newBuilder()
                .setUsername(username)
                .setEmail(email)
                .setBio(bio)
                .build();

        responseObserver.onNext(profileRes);
        responseObserver.onCompleted();
    }


    @Override
    public void updateProfile(User.UpdateProfileReq request, StreamObserver<User.APIRes> responseObserver) {
        String username = request.getUsername();
        String newEmail = request.getEmail();
        String newBio = request.getBio();
        String newPassword = request.getPassword();


        String salt = BCrypt.gensalt();
        String password = BCrypt.hashpw(newPassword, salt);

        // Update the user's profile in the database based on the provided data
        try (Connection connection = DatabaseConnector.getConnection()) {
            String updateQuery = "UPDATE users SET password = ?, email = ?, bio = ? WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, password);
                preparedStatement.setString(2, newEmail);
                preparedStatement.setString(3, newBio);
                preparedStatement.setString(4, username);


                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    // Profile update successful
                    User.APIRes updateResponse = User.APIRes.newBuilder()
                            .setResCode(200)
                            .setMessage("Profile updated successfully")
                            .build();
                    responseObserver.onNext(updateResponse);
                    logger.info("Profile update successful for user: " + username);
                } else {
                    // Profile update failed (user not found)
                    User.APIRes updateResponse = User.APIRes.newBuilder()
                            .setResCode(404)  // You can choose an appropriate error code
                            .setMessage("User not found or profile update failed")
                            .build();
                    responseObserver.onNext(updateResponse);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the database error
            User.APIRes updateResponse = User.APIRes.newBuilder()
                    .setResCode(500)  // Internal server error
                    .setMessage("Internal server error")
                    .build();
            responseObserver.onNext(updateResponse);
        }

        responseObserver.onCompleted();
    }


}


