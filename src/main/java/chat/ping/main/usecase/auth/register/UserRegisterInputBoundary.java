package chat.ping.main.usecase.auth.register;

import chat.ping.main.usecase.auth.dto.UserRegisterRequestModel;

public interface UserRegisterInputBoundary
{
    void register(UserRegisterRequestModel requestModel);
}
