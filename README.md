# Chat Ping Server

Welcome to the **Chat Ping Server**! This project is the backend implementation of a messaging application that provides secure and scalable server-side services. It handles user authentication, message exchanges, thread management, and more, making it an essential component for real-time communication platforms.

---

## Table of Contents

1. [Authors](#authors)
2. [Project Summary](#project-summary)
3. [Features](#features)
4. [Installation](#installation)
5. [Usage Guide](#usage-guide)
6. [API Documentation](#api-documentation)
7. [File Structure](#file-structure)
8. [License](#license)
9. [Feedback](#feedback)
10. [Contributing](#contributing)

---

## Authors
- CSC207: Group 167
- **Contributors:**
  -  [Ali Rahbar](https://github.com/crypto-a)
  -   [Wilton Miller](https://github.com/wiltonmiller)
  -   [Matteo Gentili](https://github.com/MatteoGentili24)
  -   [Benedict Cummins-Mburu](https://github.com/bennypk1)
  -   [Benjamin Gavriely](https://github.com/Benjamin-Uoft)
  -   [Robert Reder](https://github.com/Roppax)

---

## Project Summary

The **Chat Ping Server** was developed to provide a robust backend solution for a messaging application. It offers:

- Secure authentication and authorization using JWT.
- Real-time messaging support with thread-based communication.
- Scalable architecture using Spring Boot and PostgreSQL.
- Comprehensive API documentation for ease of integration.

---

## Features

- **User Authentication**: Secure login and registration with password hashing.
- **JWT-Based Authorization**: Stateless session management for scalability.
- **Messaging System**:
  - Create threads for group or individual messaging.
  - Send and retrieve messages within threads.
- **Swagger API Documentation**: Easily explore and test endpoints.
- **Error Handling**: Unified error response format for consistency.
- **Validation**:
  - Email and password validation for secure user management.
  - Unique username validation.
- **Database Integration**:
  - Supports PostgreSQL for production.
  - H2 in-memory database for testing.

---

## Installation

### Prerequisites

- **Java**: JDK 17+
- **Maven**: Latest version
- **PostgreSQL**: For production database
- **Git**: For cloning the repository

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/your-repo/chat-ping-server.git
   cd chat-ping-server
   ```

2. Configure the database in `application.properties`:

   - For production:
     ```
     spring.datasource.url=jdbc:postgresql://<your-db-url>:5432/<your-db-name>
     spring.datasource.username=<your-db-username>
     spring.datasource.password=<your-db-password>
     ```
   - For local testing (optional):
     ```
     spring.datasource.url=jdbc:postgresql://localhost:5432/
     spring.datasource.username=postgres
     spring.datasource.password=1230
     ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

---

## Usage Guide

1. Start the server on `http://localhost:5000/`.
2. Access the **Swagger UI** for API exploration:

   ```
   http://localhost:5000/swagger-ui/index.html
   ```

3. **Common Endpoints**:
   - **Authentication**:
     - `POST /api/v1/auth/register` - Register a new user.
     - `POST /api/v1/auth/login` - Login with credentials.
   - **Threads**:
     - `POST /api/v1/threads` - Create a new thread.
     - `GET /api/v1/threads` - List all threads.
   - **Messages**:
     - `POST /api/v1/messages` - Send a message.
     - `GET /api/v1/messages/{threadId}` - Retrieve messages in a thread.

---

## API Documentation

View the full API documentation and try out endpoints via the **Swagger UI**:

- **Swagger UI**: [http://localhost:5000/swagger-ui/index.html](http://localhost:5000/swagger-ui/index.html)

---

## File Structure

```
├── .ebextensions
│   └── nginx.config
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── chat
│   │   │       └── ping
│   │   │           ├── MainApplication.java
│   │   │           ├── config
│   │   │           ├── entity
│   │   │           ├── infrastructure
│   │   │           ├── shared
│   │   │           └── usecase
│   └── resources
│       └── application.properties
└── test
    ├── java
    └── resources
```

For a detailed breakdown, refer to the complete file structure in this README's **File Structure** section.

---

## License

This project is licensed under the MIT License. For details, refer to the `LICENSE` file.

---

## Feedback

We value your feedback! Submit your suggestions, bug reports, or feature requests via:

- [GitHub Issues](https://github.com/your-repo/chat-ping-server/issues)

---

## Contributing

We welcome contributions! To contribute:

1. Fork the repository.
2. Create a new branch (`feature-branch`).
3. Commit and push your changes.
4. Open a pull request with a detailed description (pull requet template is in the repo).

Guidelines for contributions:

- Write clear and concise commit messages.
- Ensure all tests pass before submitting a pull request.
- Follow the existing code style conventions.

--- 

Happy coding!
