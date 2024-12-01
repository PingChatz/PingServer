package chat.ping.main.infrastructure.messaging.gateway.threads;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.user.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaThreadGateway implements ThreadGateway
{
    private final JpaThreadRepository repository;

    public JpaThreadGateway(JpaThreadRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Optional<MessageThread> findThreadById(Long threadId)
    {
        return repository.findById(threadId).map(this::mapToDomain);
    }

    @Override
    public void saveThread(MessageThread thread)
    {
        ThreadDataMapper dataMapper = new ThreadDataMapper(
                thread.getThreadName(),
                thread.getParticipants().stream().map(User::getUsername).collect(Collectors.toList())
        );
        // Save and get the saved entity with generated ID
        ThreadDataMapper savedDataMapper = repository.save(dataMapper);
        // Set the generated ID back to the domain object
        thread.setThreadID(savedDataMapper.getId());
    }

    @Override
    public List<MessageThread> findThreadsByUsername(String username)
    {
        return repository.findByParticipantsContaining(username)
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    private MessageThread mapToDomain(ThreadDataMapper dataMapper)
    {
        MessageThread domainThread = new MessageThread(
                dataMapper.getId(),
                dataMapper.getName()
        );
        domainThread.setParticipants(dataMapper.getParticipants().stream()
                .map(User::new)
                .collect(Collectors.toList()));
        return domainThread;
    }
}
