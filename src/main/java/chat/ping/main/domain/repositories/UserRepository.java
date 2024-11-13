package chat.ping.main.domain.repositories;

import chat.ping.main.domain.models.User;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

    // Methods for Username
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    // Methods for Email
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}