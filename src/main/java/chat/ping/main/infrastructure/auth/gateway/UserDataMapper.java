package chat.ping.main.infrastructure.auth.gateway;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "users")
public class UserDataMapper
{
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long id;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password_hash", nullable = false)
    private String passwordHash;


    // Constructors
    public UserDataMapper()
    {
    }

    public UserDataMapper(String email, String username, String passwordHash)
    {
        this.email = email;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Long getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

}
