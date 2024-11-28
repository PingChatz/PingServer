package chat.ping.main.infrastructure.auth.controller;

import chat.ping.main.infrastructure.auth.presenter.UserRegisterPresenter;
import chat.ping.main.usecase.auth.dto.UserRegisterRequestModel;
import chat.ping.main.usecase.auth.dto.UserRegisterResponseModel;
import chat.ping.main.usecase.auth.register.UserRegisterInputBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserRegisterController
{
    private final UserRegisterInputBoundary userRegisterInputBoundary;
    private final UserRegisterPresenter presenter;

    @Autowired
    public UserRegisterController(UserRegisterInputBoundary userRegisterInputBoundary,
                                  UserRegisterPresenter presenter)
    {
        this.userRegisterInputBoundary = userRegisterInputBoundary;
        this.presenter = presenter;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequestModel requestModel)
    {
        userRegisterInputBoundary.register(requestModel);

        return presenter.getResponseEntity();
    }
}
