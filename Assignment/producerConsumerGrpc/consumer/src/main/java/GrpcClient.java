
import com.demo.grpc.User;
import com.demo.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;
import java.util.logging.Logger;


public class GrpcClient {

    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        while (true) {
            // showing welcome message
            System.out.println("Welcome to the consumer service!");
            System.out.println("Enter your choice:");
            System.out.println("1. login");
            System.out.println("2. register");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            // get rid of the newline character
            scanner.nextLine();

            boolean loggedIn = false; // flag to check if user is logged in
            String currentUser = null; // to store the current user

            // do operations according to user choice
            if (choice == 1) {
                // login user
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();

                // build the gRPC request with user input
                User.LoginExistingUser request = User.LoginExistingUser.newBuilder()
                        .setUsername(username)
                        .setPassword(password)
                        .build();

                // send the login request to the server
                User.APIRes apiResponse = userStub.loginUser(request);
                logger.info(apiResponse.getResponseStatus() + "\n" + apiResponse.getResponseMessage());

                // check if login was successful
                int status = apiResponse.getResponseStatus();

                if (status == 200) {
                    // login successful
                    System.out.println("Login successful");
                    System.out.println("Welcome " + username);
                    loggedIn = true;
                    currentUser = username;
                } else {
                    // login failed
                    System.out.println("Login failed");
                }
            } else if (choice == 2) {
                // register user
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();

                // build the gRPC request with user input
                User.RegisterNewUser request = User.RegisterNewUser.newBuilder()
                        .setUsername(username)
                        .setPassword(password)
                        .build();

                // send the register request to the server
                User.APIRes apiResponse = userStub.registerUser(request);
                logger.info(apiResponse.getResponseStatus() + "\n" + apiResponse.getResponseMessage());

                // check if register was successful
                int status = apiResponse.getResponseStatus();

                if (status == 200) {
                    // register successful
                    System.out.println("Register successful");
                    System.out.println("Welcome " + username);
                    loggedIn = true;
                    currentUser = username;
                } else {
                    // register failed
                    System.out.println("Register failed");
                }
            }

            while (loggedIn) {
                // now show profile set, profile view and profile update options
                System.out.println("Enter your choice:");
                System.out.println("1. set profile");
                System.out.println("2. view profile");
                System.out.println("3. update profile");
                System.out.println("4. logout");
                System.out.print("Your choice: ");
                choice = scanner.nextInt();
                // get rid of the newline character
                scanner.nextLine();

                // do operations according to user choice
                if (choice == 1) {
                    // set profile. firstName, lastName, email, city
                    System.out.print("Enter your first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter your last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter your city: ");
                    String city = scanner.nextLine();

                    // build the gRPC request with user input
                    User.SetProfileInfo request = User.SetProfileInfo.newBuilder()
                            .setUsername(currentUser)
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setEmail(email)
                            .setCity(city)
                            .build();

                    // send the set profile request to the server
                    User.APIRes apiResponse = userStub.setProfile(request);
                    logger.info(apiResponse.getResponseStatus() + "\n" + apiResponse.getResponseMessage());

                    // check if set profile was successful
                    int status = apiResponse.getResponseStatus();

                    if (status == 200) {
                        // set profile successful
                        System.out.println("Set profile successful");
                    } else {
                        // set profile failed
                        System.out.println("Set profile failed");
                    }

                } else if (choice == 2) {
                    // view profile
                    // build the gRPC request with user input
                    User.ProfileReq request = User.ProfileReq.newBuilder()
                            .setUsername(currentUser)
                            .build();

                    // get the profile from the server
                    User.ProfileView profile = userStub.userProfileView(request);

                    // print the profile
                    System.out.println("First name: " + profile.getFirstName());
                    System.out.println("Last name: " + profile.getLastName());
                    System.out.println("Email: " + profile.getEmail());
                    System.out.println("City: " + profile.getCity());

                } else if (choice == 3) {
                    // update profile. firstName, lastName, email, city
                    System.out.print("Enter your first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter your last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter your city: ");
                    String city = scanner.nextLine();

                    // build the gRPC request with user input
                    User.UpdateProfileInfo request = User.UpdateProfileInfo.newBuilder()
                            .setUsername(currentUser)
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setEmail(email)
                            .setCity(city)
                            .build();

                    // send the update profile request to the server
                    User.APIRes apiResponse = userStub.updateProfile(request);
                    logger.info(apiResponse.getResponseStatus() + "\n" + apiResponse.getResponseMessage());

                    // check if update profile was successful
                    int status = apiResponse.getResponseStatus();

                    if (status == 200) {
                        // update profile successful
                        System.out.println("Update profile successful");
                    } else {
                        // update profile failed
                        System.out.println("Update profile failed");
                    }
                } else if (choice == 4) {
                    // logout
                    loggedIn = false;
                    currentUser = null;
                } else {
                    // invalid choice
                    System.out.println("Invalid choice!");
                }
            }
        }

//        // close the channel
//        channel.shutdown();
//        // close the scanner
//        scanner.close();

    }
}