package chat.ping.main.entity.user;

public class User
{

    // properties
    private final String email;
    private final String username;
    private final String passwordHash;

    // Constructor
    public User(String email, String username, String passwordHash)
    {
        this.email = email;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public String getEmail()
    {
        return email;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }
}
