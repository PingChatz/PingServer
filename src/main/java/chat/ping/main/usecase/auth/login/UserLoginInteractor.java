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
    private final UserLoginPresenter presenter;
    private final JWTUtils jwtUtils;

    public UserLoginInteractor(UserAuthDsGateway userAuthDsGateway,
                               PasswordEncoder passwordEncoder,
                               UserLoginPresenter presenter,
                               JWTUtils jwtUtils)
    {
        this.userAuthDsGateway = userAuthDsGateway;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.presenter = presenter;
    }

    @Override
    public UserLoginResponseModel login(UserLoginRequestModel requestModel)
    {
        // identify if the login is being done by the username or password
        String usernameOrEmail = requestModel.getUsernameOrEmail();

        User user;
        // if it is an email
        if (EmailValidator.isValid(usernameOrEmail))
        {
            // then it must be an email
            user = userAuthDsGateway.findByEmail(requestModel.getUsernameOrEmail())
                    .orElseThrow(() -> new InvalidCredentialsException("Invalid username/email or password."));

        } else
        {
            user = userAuthDsGateway.findByUsername(requestModel.getUsernameOrEmail())
                    .orElseThrow(() -> new InvalidCredentialsException("Invalid username/email or password."));
        }

        // Verify Password
        if (!passwordEncoder.matches(requestModel.getPassword(), user.getPasswordHash())) {
            throw new InvalidCredentialsException("Invalid username/email or password.");
        }

        // Generate JWT token
        String authToken = jwtUtils.generateToken(user.getUsername(), Map.of());

        // return the success view
        return presenter.prepareSuccessView(user, authToken);
    }

}
