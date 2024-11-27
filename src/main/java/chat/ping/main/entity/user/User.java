package chat.ping.main.entity.user;

public class User
{
    private String username;
    private String password;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public boolean isPasswordValid()
    {
        return password != null && password.length() > 5;
    }
}
