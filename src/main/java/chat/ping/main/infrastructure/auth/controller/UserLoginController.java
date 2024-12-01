package chat.ping.main.infrastructure.auth.controller;


import chat.ping.main.infrastructure.auth.presenter.UserLoginPresenter;
import chat.ping.main.usecase.auth.dto.UserLoginRequestModel;
import chat.ping.main.usecase.auth.login.UserLoginInputBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserLoginController
{
    private final UserLoginInputBoundary userLoginInputBoundary;
    private final UserLoginPresenter presenter;

    @Autowired
    public UserLoginController(UserLoginInputBoundary userLoginInputBoundary,
                               UserLoginPresenter presenter)
    {
        this.userLoginInputBoundary = userLoginInputBoundary;
        this.presenter = presenter;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequestModel requestModel)
    {
        userLoginInputBoundary.login(requestModel);
        return presenter.getResponseEntity();
    }
}
