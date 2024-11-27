package chat.ping.main.usecase.auth.register;

import chat.ping.main.entity.user.User;
import chat.ping.main.entity.user.UserFactory;
import chat.ping.main.entity.user.exception.InvalidPasswordException;
import chat.ping.main.entity.user.exception.UserAlreadyExistsException;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.shared.validation.PasswordValidator;
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
        if (userAuthDsGateway.existsByUsername(requestModel.getUsername())) {
            throw new UserAlreadyExistsException("Username is already taken.");
        }

        // run to make sure password is valid
        PasswordValidator.isValid(requestModel.getPassword());


        User newUser = userFactory.createUser(
                requestModel.getEmail(),
                requestModel.getUsername(),
                requestModel.getPassword()
        );

        userAuthDsGateway.save(newUser);
        return presenter.prepareSuccessView(newUser);
    }
}
