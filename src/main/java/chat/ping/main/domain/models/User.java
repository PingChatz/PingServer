package chat.ping.main.domain.models;

import jakarta.persistence.*;
import java.util.Objects;


@Entity
@Table(name="users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
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

    // Getters and Setters
    public Long getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }

    // Override equals and hashCode for entity consistency
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, username);
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
//public class User {
//
//    String userID;
//    String userAddress;
//    String username;
//    String passwordHash;
//    String email;
//
//    public User(String username, String password, String email) {
//        // TODO: SpringBoot generate a unique userID and a userAddress
//        // TODO: hash <password> and save it locally in the "passwordHash" instance variable
//        this.username = username;
//        this.email = email;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String newUsername) {
//        this.username = newUsername;
//    }
//
//    public String getUserID() {
//        return userID;
//    }
//
//    public String getUserAddress() {
//        return userAddress;
//    }
//
//    /**
//     * @param thread is the Thread.
//     * @return True if this User is in this Thread.
//     */
//    public boolean inThread(Thread thread) {
//        return thread.userList.contains(this);
//    }
//}
