package chat.ping.main.infrastructure.auth.presenter;

import chat.ping.main.shared.error.ErrorResponse;
import chat.ping.main.usecase.auth.dto.UserLoginResponseModel;
import chat.ping.main.usecase.auth.login.UserLoginOutputBoundary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserLoginPresenter implements UserLoginOutputBoundary
{
    private ResponseEntity<?> responseEntity;

    @Override
    public void prepareSuccessView(String authToken, String username)
    {
        UserLoginResponseModel userLoginResponseModel = new UserLoginResponseModel(
                authToken,
                username,
                "Login Successful!"
        );

        this.responseEntity = ResponseEntity.status(HttpStatus.OK).body(userLoginResponseModel);
    }

    @Override
    public void prepareInvalidCredentialsView(String errorMessage)
    {
        ErrorResponse errorResponse = new ErrorResponse(
                "Invalid Credentials",
                errorMessage
        );

        this.responseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    public ResponseEntity<?> getResponseEntity()
    {
        return responseEntity;
    }
}
