package chat.ping.main.infrastructure.auth.presenter;

import chat.ping.main.usecase.auth.dto.UserLoginResponseModel;
import chat.ping.main.usecase.auth.login.UserLoginOutputBoundary;
import org.springframework.http.ResponseEntity;

public class UserLoginPresenter implements UserLoginOutputBoundary
{
    private ResponseEntity<?> responseEntity;

    @Override
    public void prepareSuccessView(String authToken, String username) {

        UserLoginResponseModel userLoginResponseModel = new UserLoginResponseModel(authToken,
                 username, "Login Successful!");

    }

    @Override
    public void invalidCredentials(String errorMessage) {


    }
}
