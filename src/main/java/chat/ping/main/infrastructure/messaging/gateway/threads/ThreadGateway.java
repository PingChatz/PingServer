package chat.ping.main.infrastructure.messaging.gateway.threads;

import chat.ping.main.entity.MessageThread.MessageThread;

import java.util.List;
import java.util.Optional;

public interface ThreadGateway
{
    Optional<MessageThread> findThreadById(Long threadId);

    void saveThread(MessageThread thread);

    List<MessageThread> findThreadsByUsername(String username);
}
