package chat.ping.main.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import chat.ping.main.domain.models.User;

/**
 * User repository is the interface used to access the user model.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

    /**
     * Returns the user object from the Database if the user exists.
     * @param username of the person.
     * @return The user object.
     */
    Optional<User> findByUsername(String username);

    /**
     *  Returns a boolean on weather or not the username exists in the database.
     * @param username of the person.
     * @return True or False depending on the existence of the username.
     */
    boolean existsByUsername(String username);

    /**
     * Returns the user object from the Database if the user exists.
     * @param email of the person.
     * @return The user object.
     */
    Optional<User> findByEmail(String email);

    /**
     *  Returns a boolean on weather or not the email exists in the database.
     * @param email of the person.
     * @return True or False depending on the existence of the email.
     */
    boolean existsByEmail(String email);

}
