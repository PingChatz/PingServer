package chat.ping.main.factories;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.Messaging.MessageFactory;
import chat.ping.main.entity.Messaging.TextMessage;
import chat.ping.main.entity.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageFactoryTest
{

    @Test
    void testCreateTextMessage()
    {
        MessageFactory factory = new MessageFactory();
        MessageThread thread = new MessageThread(1L, "General");
        User sender = new User("user1");

        TextMessage message = factory.createTextMessage("Hello!", sender, thread);

        assertEquals("Hello!", message.getContent());
        assertEquals(sender, message.getSender());
        assertEquals(thread, message.getThread());
    }
}
