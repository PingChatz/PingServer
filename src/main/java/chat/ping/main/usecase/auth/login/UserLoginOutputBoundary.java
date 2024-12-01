package chat.ping.main.usecase.auth.login;

public interface UserLoginOutputBoundary
{
    void prepareSuccessView(String authToken, String username);

    void prepareInvalidCredentialsView(String errorMessage);
}
