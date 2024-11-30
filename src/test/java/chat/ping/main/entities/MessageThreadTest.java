package chat.ping.main.entities;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.Messaging.TextMessage;
import chat.ping.main.entity.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageThreadTest
{

    @Test
    void testMessageThreadCreation()
    {
        MessageThread thread = new MessageThread(1L, "General");
        assertEquals(1L, thread.getThreadID());
        assertEquals("General", thread.getThreadName());
        assertNotNull(thread.getParticipants());
        assertNotNull(thread.getMessages());
    }

    @Test
    void testAddParticipant()
    {
        MessageThread thread = new MessageThread(1L, "General");
        User user = new User("user1");
        thread.addParticipant(user);
        assertTrue(thread.getParticipants().contains(user));
    }

    @Test
    void testAddMessage()
    {
        MessageThread thread = new MessageThread(1L, "General");
        User sender = new User("user1");
        TextMessage message = new TextMessage(thread, sender, "Hello!");
        thread.addMessage(message);
        assertTrue(thread.getMessages().contains(message));
    }
}
