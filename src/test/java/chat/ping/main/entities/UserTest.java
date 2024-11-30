package chat.ping.main.entities;

// UserTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import chat.ping.main.entity.user.User;
import chat.ping.main.entity.MessageThread.MessageThread;

public class UserTest
{

    @Test
    void testUserCreation()
    {
        User user = new User("test@example.com", "testuser", "hashedpassword");
        assertEquals("test@example.com", user.getEmail());
        assertEquals("testuser", user.getUsername());
        assertEquals("hashedpassword", user.getPasswordHash());
    }

    @Test
    void testAddThreadMessage()
    {
        User user = new User("test@example.com", "testuser", "hashedpassword");
        MessageThread thread = new MessageThread(1L, "Test Thread");
        user.addThreadMessage(thread);
        assertTrue(user.getThreadMessages().contains(thread));
    }
}
