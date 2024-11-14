package chat.ping.main.application.usecase.messaging.implementations;

import chat.ping.main.application.usecase.messaging.GetMessagesUseCase;
import chat.ping.main.domain.models.Message;
import chat.ping.main.domain.models.MessageThread;
import chat.ping.main.domain.models.User;
import chat.ping.main.domain.repositories.MessageRepository;
import chat.ping.main.domain.repositories.MessageThreadRepository;
import chat.ping.main.domain.repositories.UserRepository;
import chat.ping.main.presentation.dto.GetMessagesRequest;
import chat.ping.main.presentation.dto.MessageDTO;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetMessagesUseCaseImplementation implements GetMessagesUseCase
{
    private final UserRepository userRepository;
    private final MessageThreadRepository messageThreadRepository;
    private final MessageRepository messageRepository;

    @Override
    public List<MessageDTO> execute(String userEmail, Long threadId, int limit)
    {
        // Fetch the user by email
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + userEmail));

        // Fetch the thread by threadId
        MessageThread thread = messageThreadRepository.findByThreadId(threadId)
                .orElseThrow(() -> new IllegalArgumentException("Message thread not found with ID: " + threadId));

        // Check if user is allowed to have access to this thread
        if (!thread.getParticipants().contains(user))
        {
            throw new IllegalArgumentException("User does not have access to this thread");
        }

        // get all threads
        List<Message> messages = messageRepository.findByThreadOrderByTimestampAsc(thread);

        // limit the result to a specific count
        if (limit > 0 && messages.size() > limit)
        {
            messages = messages.subList(0, limit);
        }

        //build teh Message DTO for the first limit records and return list
        return messages.stream()
                .map(message -> new MessageDTO(
                        message.getMessageId(),
                        message.getSender().getUsername(),
                        message.getTimestamp(),
                        message.getContent()
                ))
                .collect(Collectors.toList());
    }
}
