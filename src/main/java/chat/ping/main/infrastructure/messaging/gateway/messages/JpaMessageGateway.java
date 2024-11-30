package chat.ping.main.infrastructure.messaging.gateway.messages;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.Messaging.AbstractMessage;
import chat.ping.main.entity.Messaging.TextMessage;
import chat.ping.main.entity.user.User;
import chat.ping.main.infrastructure.messaging.gateway.threads.ThreadGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaMessageGateway implements MessageGateway
{
    private final JpaMessageRepository messageRepository;
    private final ThreadGateway threadGateway;

    public JpaMessageGateway(JpaMessageRepository messageRepository, ThreadGateway threadGateway)
    {
        this.messageRepository = messageRepository;
        this.threadGateway = threadGateway;
    }

    @Override
    public List<AbstractMessage> getMessagesForThread(Long threadId)
    {
        return messageRepository.findByThreadId(threadId).stream().map(message ->
        {
            MessageThread thread = threadGateway.findThreadById(threadId)
                    .orElseThrow(() -> new IllegalArgumentException("Thread not found"));

            User sender = new User(message.getSender(), null, null);

            TextMessage textMessage = new TextMessage(thread, sender, message.getContent());
            textMessage.setTimestamp(message.getTimestamp());
            return textMessage;
        }).collect(Collectors.toList());
    }

    @Override
    public void saveMessage(AbstractMessage message)
    {
        MessageDataMapper dataMapper = new MessageDataMapper(
                message.getThread().getThreadID(),
                message.getSender().getUsername(),
                message.getContent(),
                message.getTimestamp()
        );

        messageRepository.save(dataMapper);
    }
}
