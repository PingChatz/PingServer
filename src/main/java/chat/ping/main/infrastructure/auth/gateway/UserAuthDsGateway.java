package chat.ping.main.infrastructure.auth.gateway;


import chat.ping.main.entity.user.User;

import java.util.Optional;

public interface UserAuthDsGateway
{
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    void save(User user);
}
