package chat.ping.main.usecase.auth.login;

import chat.ping.main.entity.user.User;
import chat.ping.main.usecase.auth.dto.UserLoginResponseModel;
import chat.ping.main.usecase.auth.dto.UserRegisterResponseModel;

public class UserLoginPresenter
{

    public UserLoginResponseModel prepareSuccessView(User user, String authToken)
    {
        return new UserLoginResponseModel(
                authToken,
                user.getUsername(),
                "Login successful"
                );
    }
}
