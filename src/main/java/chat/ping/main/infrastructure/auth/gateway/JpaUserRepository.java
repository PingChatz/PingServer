package chat.ping.main.infrastructure.auth.gateway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserDataMapper, Long>
{
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
