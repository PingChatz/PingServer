package chat.ping.main.entity.user;

import org.springframework.security.crypto.password.PasswordEncoder;


public class UserFactory
{
    private final PasswordEncoder passwordEncoder;

    public UserFactory(PasswordEncoder passwordEncoder)
    {
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String email, String username, String password)
    {
        String hashedPassword = passwordEncoder.encode(password);
        return new User(email, username, hashedPassword);
    }
}
