package chat.ping.main.usecase.auth.dto;

public class UserLoginRequestModel
{
    private final String usernameOrEmail;
    private final String password;


    public UserLoginRequestModel(String usernameOrEmail, String password)
    {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

    public String getUsernameOrEmail()
    {
        return usernameOrEmail;
    }

    public String getPassword()
    {
        return password;
    }
}
