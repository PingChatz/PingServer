package chat.ping.main.domain.models;


public class User {
    String userID;
    String userAddress;
    String username;
    String email;

    public User(String username, String password, String email) {
        // TODO: randomly generate a unique userID and a userAddress
        this.username = username;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserAddress() {
        return userAddress;
    }
}
