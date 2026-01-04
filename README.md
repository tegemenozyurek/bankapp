# Bank Application

A simple Spring Boot banking application with REST API endpoints for managing users, accounts, and transactions.

## Features

- User management (create, read, update, delete)
- Account management
- Deposit operations
- Withdrawal operations
- Transfer operations
- Transaction history

## Technologies

- Java 17
- Spring Boot 4.0.0
- Spring Data JPA
- MySQL
- Lombok

## Setup

1. Make sure you have Java 17 and Maven installed
2. Configure your MySQL database in `application.properties`
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Endpoints

### Users
- `GET /users/all` - Get all users
- `GET /users/{id}` - Get user by ID
- `POST /users/save` - Create a new user
- `PUT /users/update/{id}` - Update a user
- `DELETE /users/delete/{id}` - Delete a user

### Accounts
- `GET /accounts/all` - Get all accounts
- `GET /accounts/{id}` - Get account by ID
- `POST /accounts/save` - Create a new account
- `DELETE /accounts/delete/{id}` - Delete an account

### Transactions
- Deposit, withdrawal, and transfer endpoints are available

## Database

The application uses MySQL. Make sure to configure your database connection in `application.properties`.

