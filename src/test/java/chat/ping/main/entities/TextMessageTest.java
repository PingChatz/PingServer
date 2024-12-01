package chat.ping.main.entities;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.Messaging.TextMessage;
import chat.ping.main.entity.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TextMessageTest
{

    @Test
    void testTextMessageCreation()
    {
        MessageThread thread = new MessageThread(1L, "General");
        User sender = new User("user1");
        TextMessage message = new TextMessage(thread, sender, "Hello!");

        assertEquals(thread, message.getThread());
        assertEquals(sender, message.getSender());
        assertEquals("Hello!", message.getContent());
        assertNotNull(message.getTimestamp());
    }
}