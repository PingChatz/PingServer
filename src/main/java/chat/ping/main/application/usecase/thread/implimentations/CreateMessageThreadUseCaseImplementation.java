package chat.ping.main.application.usecase.thread.implimentations;


import chat.ping.main.application.usecase.thread.CreateMessageThreadUseCase;
import chat.ping.main.domain.models.MessageThread;
import chat.ping.main.domain.models.User;
import chat.ping.main.domain.repositories.MessageThreadRepository;
import chat.ping.main.domain.repositories.UserRepository;
import chat.ping.main.presentation.dto.CreateMessageThreadRequest;
import chat.ping.main.presentation.dto.CreateMessageThreadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateMessageThreadUseCaseImplementation implements CreateMessageThreadUseCase
{
    private final UserRepository userRepository;
    private final MessageThreadRepository messageThreadRepository;

    @Override
    public CreateMessageThreadResponse execute(String userEmail, CreateMessageThreadRequest createMessageThreadRequest)
    {
        // Fetch the user by email
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + userEmail));

        // Collect the list of users
        List<User> users = new ArrayList<>();
        users.add(user);

        // Fetch participants by username and validate them
        for (String username : createMessageThreadRequest.getParticipantUsernames()) {
            User participant = userRepository.findByUsername(username)
                    .orElseThrow(() -> new IllegalArgumentException("Username does not exist: " + username));
            users.add(participant);
        }

        // Create a new message thread and save it
        MessageThread newMessageThread = new MessageThread(createMessageThreadRequest.getThreadName(), users);
        messageThreadRepository.save(newMessageThread);

        // Return response with thread ID and name
        return new CreateMessageThreadResponse(newMessageThread.getThreadId(), newMessageThread.getThreadName());
    }

}
