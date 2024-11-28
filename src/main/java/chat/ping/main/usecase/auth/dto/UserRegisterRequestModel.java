package chat.ping.main.usecase.auth.dto;

public class UserRegisterRequestModel
{
    private final String username;
    private final String password;
    private final String email;

    public UserRegisterRequestModel(String username, String password, String email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}
