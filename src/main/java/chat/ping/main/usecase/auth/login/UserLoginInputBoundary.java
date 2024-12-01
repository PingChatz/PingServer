package chat.ping.main.usecase.auth.login;

import chat.ping.main.usecase.auth.dto.UserLoginRequestModel;

public interface UserLoginInputBoundary
{
    void login(UserLoginRequestModel requestModel);
}
