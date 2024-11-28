package chat.ping.main.usecase.auth.login;

import chat.ping.main.usecase.auth.dto.UserLoginRequestModel;
import chat.ping.main.usecase.auth.dto.UserLoginResponseModel;

public interface UserLoginInputBoundary
{
    void login(UserLoginRequestModel requestModel);
}
