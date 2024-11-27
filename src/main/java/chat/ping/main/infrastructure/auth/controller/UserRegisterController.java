package chat.ping.main.infrastructure.auth.controller;

import chat.ping.main.usecase.auth.dto.UserRegisterRequestModel;
import chat.ping.main.usecase.auth.dto.UserRegisterResponseModel;
import chat.ping.main.usecase.auth.register.UserRegisterInputBoundary;
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

    public UserRegisterController(UserRegisterInputBoundary userRegisterInputBoundary)
    {
        this.userRegisterInputBoundary = userRegisterInputBoundary;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseModel> register(@RequestBody UserRegisterRequestModel requestModel)
    {
        UserRegisterResponseModel response = userRegisterInputBoundary.register(requestModel);

        return ResponseEntity.ok(response);
    }
}
