package chat.ping.main.infrastructure.auth.gateway;


import chat.ping.main.entity.user.User;

public interface UserAuthDsGateway
{
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void save(User user);
}
