package chat.ping.main.infrastructure.security;

import chat.ping.main.infrastructure.auth.gateway.JpaUserRepository;
import chat.ping.main.infrastructure.auth.gateway.UserDataMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService
{

    private final JpaUserRepository userRepository;

    public UserDetailsServiceImplementation(JpaUserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    /**
     * Loads user-specific data by username or email for Spring Security.
     *
     * @param username The username provided during login.
     * @return UserDetails containing user information (username, password, authorities).
     * @throws UsernameNotFoundException if no user is found with the provided username/email.
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException
    {
        // Attempt to find user by username or email
        UserDataMapper user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with Username: " + username));

        // Return UserDetails object expected by Spring Security
        return User.builder()
                .username(user.getUsername())
                .password(user.getPasswordHash()) // Password must be hashed
                .authorities("ROLE_USER") // Default role, can be adjusted based on user data
                .build();
    }
}
