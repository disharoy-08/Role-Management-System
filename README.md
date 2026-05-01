# Role Permission Management System

A robust Role and Permission Management System built with Java, Spring Boot, Spring Security, and JWT for secure authentication and authorization.

## Features

- **User Authentication**: Secure login and JWT token generation.
- **Role Management**: Create, read, update, and assign roles to users.
- **Permission Management**: Granular access control utilizing individual permissions.
- **Security**: Stateless, secure authentication using JSON Web Tokens (JWT).
- **Database Architecture**: Data persistence using Spring Data JPA and Microsoft SQL Server.

## Tech Stack

- **Backend**: Java 17, Spring Boot (Web, Security, Data JPA, Validation)
- **Database**: Microsoft SQL Server
- **Security**: JSON Web Tokens (jjwt)
- **Build Tool**: Maven

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17
- Maven
- Microsoft SQL Server running locally or remotely

### Local Development Setup

1. **Clone the repository:**
   ```bash
   git clone <your-github-repo-url>
   cd Role_Management
   ```

2. **Configure the database:**
   The project uses `application.yml` for local development. Update `src/main/resources/application.yml` with your local database credentials if they differ from the defaults.

3. **Run the application:**
   You can run the application directly using Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```
   Or, build it and run the JAR:
   ```bash
   ./mvnw clean install
   java -jar target/Role_Management-0.0.1-SNAPSHOT.jar
   ```

## Preparing for Production

This project includes an `application-prod.yml` profile configured specifically for production environments. It enforces security best practices such as disabling SQL logging, validating the database schema instead of auto-updating it, and requiring environment variables for sensitive credentials.

### Production Environment Variables

Before deploying, you **must** set the following environment variables on your production server or container:

- `DB_URL`: The full JDBC connection string for your production database.
- `DB_USERNAME`: Database username.
- `DB_PASSWORD`: Database password.
- `JWT_SECRET`: A strong, randomly generated secret string (at least 256 bits / 32 characters) used to sign the JWTs.

### Running in Production

1. **Build the production-ready JAR:**
   ```bash
   ./mvnw clean package -DskipTests
   ```

2. **Run with the `prod` profile:**
   Activate the production profile using the `-Dspring.profiles.active=prod` flag:
   ```bash
   java -jar -Dspring.profiles.active=prod target/Role_Management-0.0.1-SNAPSHOT.jar
   ```

## Project Structure Highlights

- `entity/`: JPA entities representing database tables (User, Role, Permission).
- `dto/`: Data Transfer Objects for API requests and responses (e.g., `LoginRequest`, `AssignRoleRequest`).
- `repository/`: Spring Data JPA repositories for database interactions.
- `service/`: Business logic layer.
- `controller/`: REST API endpoints.
- `security/`: JWT filters, authentication entry points, and security configurations.

