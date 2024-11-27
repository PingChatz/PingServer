package chat.ping.main.infrastructure.auth.gateway;


import chat.ping.main.entity.user.User;

public interface UserAuthDsGateway
{
    boolean existsByUsername(String username);

    void save(User user);
}
