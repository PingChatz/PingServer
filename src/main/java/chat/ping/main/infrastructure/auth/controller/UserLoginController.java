package chat.ping.main.infrastructure.auth.controller;


import chat.ping.main.usecase.auth.dto.UserLoginRequestModel;
import chat.ping.main.usecase.auth.dto.UserLoginResponseModel;
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

    @Autowired
    public UserLoginController(UserLoginInputBoundary userLoginInputBoundary)
    {
        this.userLoginInputBoundary = userLoginInputBoundary;
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseModel> login(@RequestBody UserLoginRequestModel requestModel)
    {
        UserLoginResponseModel response = userLoginInputBoundary.login(requestModel);

        return ResponseEntity.ok(response);
    }
}
