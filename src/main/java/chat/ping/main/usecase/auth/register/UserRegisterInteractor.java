package chat.ping.main.usecase.auth.register;

import chat.ping.main.entity.user.User;
import chat.ping.main.entity.user.UserFactory;
import chat.ping.main.entity.user.exception.UserAlreadyExistsException;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.usecase.auth.dto.UserRegisterRequestModel;
import chat.ping.main.usecase.auth.dto.UserRegisterResponseModel;

public class UserRegisterInteractor implements UserRegisterInputBoundary
{
    private final UserAuthDsGateway userAuthDsGateway;
    private final UserRegisterPresenter presenter;
    private final UserFactory userFactory;

    public UserRegisterInteractor(UserAuthDsGateway userAuthDsGateway, UserRegisterPresenter presenter, UserFactory userFactory)
    {
        this.userAuthDsGateway = userAuthDsGateway;
        this.presenter = presenter;
        this.userFactory = userFactory;
    }

    @Override
    public UserRegisterResponseModel register(UserRegisterRequestModel requestModel)
    {
        // Check if user already exists
        if (userAuthDsGateway.existsByUsername(requestModel.getUsername())) {
            throw new UserAlreadyExistsException("Username is already taken.");
        }

        // Validate password
        if (!PasswordValidator.isValid(requestModel.getPassword())) {
            throw new IllegalArgumentException("Password does not meet validation criteria.");
        }

        // Create a new user
        User newUser = userFactory.createUser(
                requestModel.getEmail(),
                requestModel.getUsername(),
                requestModel.getPassword()
        );

        // Save the user to the repository
        userAuthDsGateway.save(newUser);

        // Return response through the presenter
        return presenter.prepareSuccessView(newUser);
    }
}
