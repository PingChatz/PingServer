# Features (Use Cases)
- Send messages
- Receive messages
- Auth (sign in, sign up)

# Entities

## User
- String userID           (a unique identifier for the user within the database)
- String userAddress      (a unique identifier for each user that's publicly displayed like Discord tags)
- String username
- String passwordHash
- String email

## Thread
- String threadID
- String name
- List<User> userList
- List<Message> messageList

## Message (Abstract)
- String threadID
- String senderID         (the ID of the user that sent the message)
- Object content          (it's type will change based on the child class)

## TextMessage implements Message
- String content


## Suggested Project Infrastructure (Clean Architecture)
~~~arduino
project-root/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.example.project/
│   │   │   │   ├── entity/
│   │   │   │   │   ├── auth/
│   │   │   │   │   │   ├── User.java
│   │   │   │   │   │   ├── UserFactory.java
│   │   │   │   │   │   ├── exception/
│   │   │   │   │   │   │   ├── UserAlreadyExistsException.java
│   │   │   │   │   │   │   ├── InvalidPasswordException.java
│   │   │   │   │   │   │   └── InvalidCredentialsException.java
│   │   │   │   ├── usecase/
│   │   │   │   │   ├── auth/
│   │   │   │   │   │   ├── dto/
│   │   │   │   │   │   │   ├── UserRegisterRequestModel.java
│   │   │   │   │   │   │   ├── UserRegisterResponseModel.java
│   │   │   │   │   │   │   ├── UserLoginRequestModel.java
│   │   │   │   │   │   │   ├── UserLoginResponseModel.java
│   │   │   │   │   │   ├── register/
│   │   │   │   │   │   │   ├── UserRegisterInteractor.java
│   │   │   │   │   │   │   ├── UserRegisterInputBoundary.java
│   │   │   │   │   │   │   ├── UserRegisterPresenter.java
│   │   │   │   │   │   ├── login/
│   │   │   │   │   │   │   ├── UserLoginInteractor.java
│   │   │   │   │   │   │   ├── UserLoginInputBoundary.java
│   │   │   │   │   │   │   ├── UserLoginPresenter.java
│   │   │   │   ├── infrastructure/
│   │   │   │   │   ├── auth/
│   │   │   │   │   │   ├── controller/
│   │   │   │   │   │   │   ├── UserRegisterController.java
│   │   │   │   │   │   │   ├── UserLoginController.java
│   │   │   │   │   │   ├── gateway/
│   │   │   │   │   │   │   ├── UserAuthDsGateway.java
│   │   │   │   │   │   │   ├── JpaUserRepository.java
│   │   │   │   │   │   │   ├── UserDataMapper.java
│   │   │   │   │   │   │   └── JpaUserGateway.java
│   │   │   │   │   │   └── formatter/
│   │   │   │   │   │       ├── UserRegisterResponseFormatter.java
│   │   │   │   │   │       ├── UserLoginResponseFormatter.java
│   │   │   │   │   │       └── exception/
│   │   │   │   │   │           └── ResponseExceptionHandler.java
│   │   │   │   ├── application/
│   │   │   │   │   ├── config/
│   │   │   │   │   │   ├── AppConfig.java
│   │   │   │   │   └── main/
│   │   │   │   │       ├── CleanArchitectureApplication.java
│   │   │   │   └── shared/
│   │   │   │       ├── validation/
│   │   │   │       │   ├── PasswordValidator.java
│   │   │   │       │   ├── CredentialsValidator.java
│   │   │   │       │   └── UniqueUsernameValidator.java
│   │   │   │       └── util/
│   │   │   │           ├── DateFormatter.java
│   │   │   │           └── JsonUtil.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── db/
│   │       │   ├── schema.sql
│   │       │   └── data.sql
│   │       └── messages/
│   │           └── validation_messages.properties
│   ├── test/
│       ├── java/
│       │   ├── com.example.project/
│       │   │   ├── entity/
│       │   │   ├── usecase/
│       │   │   ├── infrastructure/
│       │   │   └── shared/


~~~