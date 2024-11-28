package chat.ping.main.usecase.auth.login;

import chat.ping.main.usecase.auth.dto.UserLoginResponseModel;

public interface UserLoginOutputBoundary
{
    void prepareSuccessView(UserLoginResponseModel responseModel,String successmessage);

    void invalidCredentials(String errorMessage);
}
