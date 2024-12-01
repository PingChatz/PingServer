package chat.ping.main.factories;

import chat.ping.main.entity.user.User;
import chat.ping.main.entity.user.UserFactory;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class UserFactoryTest
{

    @Test
    void testCreateUser()
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserFactory userFactory = new UserFactory(passwordEncoder);
        User user = userFactory.createUser("test@example.com", "testuser", "Password123!");

        assertEquals("test@example.com", user.getEmail());
        assertEquals("testuser", user.getUsername());
        assertNotNull(user.getPasswordHash());
        assertTrue(passwordEncoder.matches("Password123!", user.getPasswordHash()));
    }
}
