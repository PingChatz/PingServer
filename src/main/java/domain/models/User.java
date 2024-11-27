package domain.models;


import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.SEQUENCE;


/**
 * User entity.
 * Used to handle user objects as well as communicate with db.
 */
@Entity(name="User")
public class User
{
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long id;

    @Column(name="username", nullable = false, unique = true)
    @Getter
    private String username;

    @Getter
    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Getter
    @Column(name="password_hash", nullable = false)
    private String passwordHash;

    // Default constructor (required by JPA)
    public User()
    { }

    // Constructor with fields
    public User(String username, String email, String passwordHash)
    {
        // Initialize the values
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }

}
