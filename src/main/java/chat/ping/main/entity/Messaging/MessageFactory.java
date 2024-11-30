package chat.ping.main.entity.Messaging;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.user.User;

public class MessageFactory
{
    public TextMessage createTextMessage(String content, User sender, MessageThread thread)
    {
        return new TextMessage(thread, sender, content);
    }
}
