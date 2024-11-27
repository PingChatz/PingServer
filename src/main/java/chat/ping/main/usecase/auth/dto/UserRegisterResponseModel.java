package chat.ping.main.usecase.auth.dto;

public class UserRegisterResponseModel
{

    private final String username;
    private final String message;

    public UserRegisterResponseModel(String username, String message)
    {
        this.username = username;
        this.message = message;
    }

    public String getUsername()
    {
        return username;
    }

    public String getMessage()
    {
        return message;
    }
}
