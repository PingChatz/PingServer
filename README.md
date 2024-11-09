## Features (Use Cases)
- Send messages
- Receive messages
- Auth (sign in, sign up)

## Objects (Entities)

# User
- userID (for database access)
- user address (randomly generated unique string)
- username
- password hash?
- email

# Thread (Chatroom)
- id
- name
- list of users

# Message (Abstract)
- thread id
- sender (user id)
- content (of type Text, Image, etc...)

# TextMessage implements Message

# Text (the content of a TextMessage)
