package chat.ping.main.application.usecase.thread.implimentations;


import chat.ping.main.application.usecase.thread.GetMessageThreadsUserCase;
import chat.ping.main.domain.models.MessageThread;
import chat.ping.main.domain.models.User;
import chat.ping.main.domain.repositories.UserRepository;
import chat.ping.main.presentation.dto.MessageThreadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetMessageThreadsUseCaseImplementation implements GetMessageThreadsUserCase
{
    private final UserRepository userRepository;

    @Override
    public List<MessageThreadResponse> execute(String email)
    {
        // Initialize the list to store the response
        final List<MessageThreadResponse> result = new ArrayList<>();

        // Fetch the user by email
        Optional<User> userOptional = userRepository.findByEmail(email);

        // collect the user then
        User user = userOptional.get();

        // Check if the user has any threads
        List<MessageThread> threads = user.getThreads();

        // Check if user exists
        if (threads.isEmpty())
        {
            return result;
        }

        // Convert threads to MessageThreadResponse and add to result list
        for (MessageThread thread : threads)
        {
            result.add(new MessageThreadResponse(
                    thread.getThreadId(),
                    thread.getThreadName()
            ));
        }

        return result;
    }
}
