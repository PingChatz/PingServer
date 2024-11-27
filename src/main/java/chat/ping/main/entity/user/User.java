package chat.ping.main.entity.user;

public class User
{

    // properties
    private final String email;
    private final String username;
    private final String password;

    // Constructor
    public User(String username, String password, String email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
