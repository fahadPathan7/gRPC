# Producer-Consumer Management System using gRPC

This project demonstrates a producer-consumer management system using gRPC, allowing interaction between producers and consumers.

## Features

The system offers the following features:

- **New user registration:** Register new users by providing a username and password. Duplicate usernames are not allowed.

- **Existing user login:** Existing users can log in using their registered username and password.

- **Profile creation:** After successful login, users can create their profile by providing:
    - First name
    - Last name
    - Email address
    - City

- **View profile:** Users can view their profile, displaying either the profile information or a message indicating that the profile is not yet created.

- **Edit profile:** Users can edit their profile information, including first name, last name, email address, and city. Usernames cannot be changed.

## How to Run

### Database Setup

1. Create a database named `grpc` in MySQL (e.g., using XAMPP).

2. Create the `users` and `profiles` tables using the following SQL statements:

```sql
-- Create the 'users' table
CREATE TABLE users (
  username VARCHAR(255),
  password VARCHAR(255)
);

-- Create the 'profiles' table
CREATE TABLE profiles (
  username VARCHAR(255),
  firstname VARCHAR(255),
  lastname VARCHAR(255),
  email VARCHAR(255),
  city VARCHAR(255)
);
```


### Project Setup

1. Open the `producerConsumerGrpc` project on intellIJ.

2. Load Maven dependencies.

### Running the Project

1. Run the `grpcServer.java` file to start the gRPC server.

2. Run the `grpcClient.java` file to start the gRPC client.

3. Follow the prompts in the client application to perform various actions, such as registering a new user, logging in, creating a profile, viewing a profile, or editing a profile.
