
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

        // Create a Scanner to capture user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose between login and registration
        System.out.println("Choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            // User chose login
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // Build the gRPC request with user input
            User.LoginReq request = User.LoginReq.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .build();

            // Send the login request to the server
            User.APIRes apiRes = userStub.login(request);
            logger.info(apiRes.getResCode() + "\n" + apiRes.getMessage());
            // Assuming login was successful
            boolean loggedIn;
            if(apiRes.getMessage().equals("SUCCESS")) loggedIn = true;
            else loggedIn = false;

            while (loggedIn) {
                System.out.println("-------------------------------------");
                System.out.println("Choose an option:");
                System.out.println("1. Show Profile");
                System.out.println("2. Update Profile");
                System.out.println("3. Exit");
                System.out.print("Enter your choice (1, 2, or 3): ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (option == 1) {
                    // Show User Profile
                    User.ProfileReq profileReq = User.ProfileReq.newBuilder()
                            .setUsername(username)
                            .build();
                    User.ProfileRes profileRes = userStub.getProfile(profileReq);
                    System.out.println("-------------------------------------");
                    System.out.println("User Profile:");
                    System.out.println("Username: " + profileRes.getUsername());
                    System.out.println("Email: " + profileRes.getEmail());
                    System.out.println("Bio: " + profileRes.getBio());
                    System.out.println("-------------------------------------");
                } else if (option == 2) {
                    // Update Profile
                    System.out.print("Enter your new email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter your new bio: ");
                    String newBio = scanner.nextLine();
                    System.out.print("Enter your new password: ");
                    String newPassword = scanner.nextLine();

                    User.UpdateProfileReq updateProfileReq = User.UpdateProfileReq.newBuilder()
                            .setUsername(username)
                            .setEmail(newEmail)
                            .setBio(newBio)
                            .setPassword(newPassword)
                            .build();

                    User.APIRes updateRes = userStub.updateProfile(updateProfileReq);
                    System.out.println("Profile update response: " + updateRes.getMessage());
                } else if (option == 3) {
                    // Exit the program
                    loggedIn = false;
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        } else if (choice == 2) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your email: ");
            String email = scanner.nextLine();

            System.out.print("Enter your bio: ");
            String bio = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // Build the gRPC request for registration
            User.RegisterReq registerReq = User.RegisterReq.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .setEmail(email)
                    .setBio(bio)
                    .build();

            // Send the registration request to the server
            User.APIRes apiRes = userStub.register(registerReq);
            logger.info(apiRes.getResCode() + "\n" + apiRes.getMessage());



        } else {
            System.out.println("Invalid choice.");
        }

        // Close the scanner and channel
        scanner.close();
        channel.shutdown();
    }
}
