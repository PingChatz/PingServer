package chat.ping.main.domain.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity(name="User")
public class User
{
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long id;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Getter
    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Getter
    @Column(name="password_hash", nullable = false)
    private String passwordHash;

    @ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
    private List<MessageThread> threads;

    // Default constructor (required by JPA)
    public User()
    {}

    // Constructor with fields
    public User(String username, String email, String passwordHash)
    {
        // Initialize the values
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.threads = new ArrayList<>();
    }


}