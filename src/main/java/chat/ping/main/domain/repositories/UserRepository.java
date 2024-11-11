package chat.ping.main.domain.repositories;

import chat.ping.main.domain.models.User;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

    // Method to find a user by username
    Optional<User> findByUsername(String username);

    // Method to check if a user with a given username exists
    boolean existsByUsername(String username);

}