package chat.ping.main.usecase.auth.register;

import chat.ping.main.usecase.auth.dto.UserRegisterRequestModel;
import chat.ping.main.usecase.auth.dto.UserRegisterResponseModel;

public interface UserRegisterInputBoundary
{
    void register(UserRegisterRequestModel requestModel);
}
