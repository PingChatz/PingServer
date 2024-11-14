package chat.ping.main.application.usecase.messaging.implementations;

import chat.ping.main.application.usecase.messaging.SendMessageUseCase;
import chat.ping.main.domain.models.Message;
import chat.ping.main.domain.models.MessageThread;
import chat.ping.main.domain.models.TextMessage;
import chat.ping.main.domain.models.User;
import chat.ping.main.domain.repositories.MessageRepository;
import chat.ping.main.domain.repositories.MessageThreadRepository;
import chat.ping.main.domain.repositories.UserRepository;
import chat.ping.main.presentation.dto.MessageThreadResponse;
import chat.ping.main.presentation.dto.SendMessageRequest;
import chat.ping.main.presentation.dto.SendMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendMessageUseCaseImplementation implements SendMessageUseCase
{
    private final UserRepository userRepository;
    private final MessageThreadRepository messageThreadRepository;
    private final MessageRepository messageRepository;

    @Override
    public SendMessageResponse execute(String userEmail, SendMessageRequest sendMessageRequest)
    {
        // Fetch the user by email
        User sender = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + userEmail));

        // Fetch the thread by threadId
        MessageThread thread = messageThreadRepository.findByThreadId(sendMessageRequest.getThreadId())
                .orElseThrow(() -> new IllegalArgumentException("Message thread not found with ID: " + sendMessageRequest.getThreadId()));

        // Initialize teh message
        Message message;

        // Switch Statement
        switch (sendMessageRequest.getMessageType())
        {
            case "text":
                message = new TextMessage(sendMessageRequest.getContent(), sender, thread);
                break;
            // Other message systems can be implemented later.
            default:
                throw new IllegalArgumentException("Unsupported message type: " + sendMessageRequest.getMessageType());
        }

        messageRepository.save(message);

        SendMessageResponse response = new SendMessageResponse(message.getTimestamp(), message.getContent());

        return response;
    }
}
