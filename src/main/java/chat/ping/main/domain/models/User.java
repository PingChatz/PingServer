package chat.ping.main.domain.models;


import jakarta.persistence.*;


@Entity
@Table(name="users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
