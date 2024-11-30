package chat.ping.main.infrastructure.messaging.gateway.messages;

import chat.ping.main.entity.Messaging.AbstractMessage;

import java.util.List;

public interface MessageGateway
{
    List<AbstractMessage> getMessagesForThread(Long threadId);

    void saveMessage(AbstractMessage message);
}
