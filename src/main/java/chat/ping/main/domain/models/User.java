package chat.ping.main.domain.models;

import jakarta.persistence.*;
import java.util.Objects;

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

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password_hash", nullable = false)
    private String passwordHash;


    // Default constructor (required by JPA)
    public User()
    {}

    // Constructor with fields
    public User(String username, String passwordHash)
    {
        this.username = username;
        this.passwordHash = passwordHash;
    }


}
////public class User {
////
////    String userID;
////    String userAddress;
////    String username;
////    String passwordHash;
////    String email;
////
////    public User(String username, String password, String email) {
////        // TODO: SpringBoot generate a unique userID and a userAddress
////        // TODO: hash <password> and save it locally in the "passwordHash" instance variable
////        this.username = username;
////        this.email = email;
////    }
////
////    public String getEmail() {
////        return email;
////    }
////
////    public void setEmail(String email) {
////        this.email = email;
////    }
////
////    public String getUsername() {
////        return username;
////    }
////
////    public void setUsername(String newUsername) {
////        this.username = newUsername;
////    }
////
////    public String getUserID() {
////        return userID;
////    }
////
////    public String getUserAddress() {
////        return userAddress;
////    }
////
////    /**
////     * @param thread is the Thread.
////     * @return True if this User is in this Thread.
////     */
////    public boolean inThread(Thread thread) {
////        return thread.userList.contains(this);
////    }
////}
