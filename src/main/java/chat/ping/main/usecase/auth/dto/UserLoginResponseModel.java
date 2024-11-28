package chat.ping.main.usecase.auth.dto;

public class UserLoginResponseModel
{
    private final String authToken;
    private final String username;
    private final String message;

    public UserLoginResponseModel(String authToken, String username, String message)
    {
        this.authToken = authToken;
        this.username = username;
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public String getAuthToken()
    {
        return authToken;
    }

    public String getUsername()
    {
        return username;
    }
}
