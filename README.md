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


## Suggested Project Infrastructure
~~~arduino
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── messagingapp
│   │               ├── application
│   │               │   ├── usecase
│   │               │   │   ├── auth
│   │               │   │   │   ├── SignInUseCase.java
│   │               │   │   │   └── SignUpUseCase.java
│   │               │   │   └── messaging
│   │               │   │       ├── SendMessageUseCase.java
│   │               │   │       └── ReceiveMessageUseCase.java
│   │               │   ├── service
│   │               │   │   ├── AuthService.java
│   │               │   │   └── MessagingService.java
│   │               │   └── websocket
│   │               │       └── WebSocketHandler.java
│   │               ├── domain
│   │               │   ├── model
│   │               │   │   ├── User.java
│   │               │   │   ├── Thread.java
│   │               │   │   ├── Message.java
│   │               │   │   └── TextMessage.java
│   │               │   └── repository
│   │               │       ├── UserRepository.java
│   │               │       ├── ThreadRepository.java
│   │               │       └── MessageRepository.java
│   │               ├── infrastructure
│   │               │   ├── persistence
│   │               │   │   ├── JpaUserRepository.java
│   │               │   │   ├── JpaThreadRepository.java
│   │               │   │   ├── JpaMessageRepository.java
│   │               │   │   └── config
│   │               │   │       └── PostgresConfig.java
│   │               │   └── websocket
│   │               │       └── WebSocketConfig.java
│   │               ├── presentation
│   │               │   ├── controller
│   │               │   │   ├── AuthController.java
│   │               │   │   ├── MessageController.java
│   │               │   │   └── HelloWorldController.java
│   │               │   ├── dto
│   │               │   │   ├── UserDTO.java
│   │               │   │   ├── ThreadDTO.java
│   │               │   │   └── MessageDTO.java
│   │               │   └── websocket
│   │               │       └── WebSocketMessageController.java
│   │               └── config
│   │                   ├── SecurityConfig.java
│   │                   └── WebSocketSecurityConfig.java
│   └── resources
│       ├── application.properties
│       └── schema.sql
└── test
    └── java
        └── com
            └── example
                └── messagingapp
                    ├── usecase
                    │   ├── AuthUseCaseTests.java
                    │   └── MessagingUseCaseTests.java
                    ├── controller
                    │   ├── AuthControllerTests.java
                    │   ├── MessageControllerTests.java
                    │   └── HelloWorldControllerTests.java
                    └── websocket
                        └── WebSocketHandlerTests.java

~~~