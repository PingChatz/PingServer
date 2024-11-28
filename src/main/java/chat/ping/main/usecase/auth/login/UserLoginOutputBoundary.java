package chat.ping.main.usecase.auth.login;

import chat.ping.main.usecase.auth.dto.UserLoginResponseModel;

public interface UserLoginOutputBoundary
{
    void prepareSuccessView(String authToken,String username);

    void prepareInvalidCredentialsView(String errorMessage);
}
