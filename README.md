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