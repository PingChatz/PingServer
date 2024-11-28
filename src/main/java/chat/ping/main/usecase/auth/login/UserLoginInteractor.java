package chat.ping.main.usecase.auth.login;

import chat.ping.main.entity.user.User;
import chat.ping.main.entity.user.exception.InvalidCredentialsException;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.infrastructure.security.JWTUtils;
import chat.ping.main.shared.validation.EmailValidator;
import chat.ping.main.usecase.auth.dto.UserLoginRequestModel;
import chat.ping.main.usecase.auth.dto.UserLoginResponseModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Map;


public class UserLoginInteractor implements UserLoginInputBoundary
{
    private final UserAuthDsGateway userAuthDsGateway;
    private final PasswordEncoder passwordEncoder;
    private final UserLoginOutputBoundary presenter;
    private final JWTUtils jwtUtils;

    public UserLoginInteractor(UserAuthDsGateway userAuthDsGateway,
                               PasswordEncoder passwordEncoder,
                               UserLoginOutputBoundary presenter,
                               JWTUtils jwtUtils)
    {
        this.userAuthDsGateway = userAuthDsGateway;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.presenter = presenter;
    }

    @Override
    public void login(UserLoginRequestModel requestModel)
    {
        // identify if the login is being done by the username or password
        String usernameOrEmail = requestModel.getUsernameOrEmail();

        // Fetch user by email or username
        User user = fetchUserByUsernameOrEmail(usernameOrEmail);

        // Validate the password
        if (!passwordEncoder.matches(requestModel.getPassword(), user.getPasswordHash())) {
            presenter.prepareInvalidCredentialsView("Invalid username/email or password.");
            return;
        }

        // Generate JWT token
        String authToken = jwtUtils.generateToken(user.getUsername(), Map.of());

        // Prepare the success response
        presenter.prepareSuccessView(authToken, user.getUsername());
    }

    private User fetchUserByUsernameOrEmail(String usernameOrEmail) {
        if (EmailValidator.isValid(usernameOrEmail)) {
            return userAuthDsGateway.findByEmail(usernameOrEmail)
                    .orElseThrow(() -> new InvalidCredentialsException("Invalid username/email or password."));
        } else {
            return userAuthDsGateway.findByUsername(usernameOrEmail)
                    .orElseThrow(() -> new InvalidCredentialsException("Invalid username/email or password."));
        }
    }

}
