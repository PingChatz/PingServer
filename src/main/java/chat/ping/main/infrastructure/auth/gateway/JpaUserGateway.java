package chat.ping.main.infrastructure.auth.gateway;

import chat.ping.main.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public class JpaUserGateway implements UserAuthDsGateway
{
    private final JpaUserRepository userRepository;

    public JpaUserGateway(JpaUserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByUsername(String username)
    {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email)
    {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void save(User user)
    {
        UserDataMapper userDataMapper = new UserDataMapper(user.getEmail(), user.getUsername(), user.getPassword());
        userRepository.save(userDataMapper);
    }
}
