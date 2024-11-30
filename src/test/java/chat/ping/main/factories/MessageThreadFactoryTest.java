package chat.ping.main.factories;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.MessageThread.MessageThreadFactory;
import chat.ping.main.entity.user.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MessageThreadFactoryTest
{

    @Test
    void testCreateThread()
    {
        MessageThreadFactory factory = new MessageThreadFactory();
        User user1 = new User("user1");
        User user2 = new User("user2");
        List<User> participants = Arrays.asList(user1, user2);

        MessageThread thread = factory.createThread("Test Thread", participants);

        assertNull(thread.getThreadID()); // Since ID is set after saving to DB
        assertEquals("Test Thread", thread.getThreadName());
        assertEquals(participants, thread.getParticipants());
    }
}
