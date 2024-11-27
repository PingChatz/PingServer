package chat.ping.main.usecase.auth.register;


import chat.ping.main.entity.user.User;
import chat.ping.main.usecase.auth.dto.UserRegisterResponseModel;

public class UserRegisterPresenter
{
    public UserRegisterResponseModel prepareSuccessView(User user)
    {
        return new UserRegisterResponseModel(user.getUsername(), "User registered successfully!");
    }
}
