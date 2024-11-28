package chat.ping.main.usecase.auth.register;

import chat.ping.main.entity.user.User;
import chat.ping.main.entity.user.UserFactory;
import chat.ping.main.entity.user.exception.UserAlreadyExistsException;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.shared.validation.EmailValidator;
import chat.ping.main.shared.validation.PasswordValidator;
import chat.ping.main.usecase.auth.dto.UserRegisterRequestModel;
import chat.ping.main.usecase.auth.dto.UserRegisterResponseModel;

public class UserRegisterInteractor implements UserRegisterInputBoundary
{
    private final UserAuthDsGateway userAuthDsGateway;
    private final UserRegisterOutputBoundary presenter;
    private final UserFactory userFactory;

    public UserRegisterInteractor(UserAuthDsGateway userAuthDsGateway,
                                  UserRegisterOutputBoundary presenter,
                                  UserFactory userFactory)
    {
        this.userAuthDsGateway = userAuthDsGateway;
        this.presenter = presenter;
        this.userFactory = userFactory;
    }

    @Override
    public void register(UserRegisterRequestModel requestModel)
    {
        // make sure username us unique
        if (userAuthDsGateway.existsByUsername(requestModel.getUsername()))
        {
            presenter.prepareUsernameAlreadyExistsView(requestModel.getUsername());
            return;
        }

        // make sure email is unique
        if (userAuthDsGateway.existsByEmail(requestModel.getEmail()))
        {
            presenter.prepareEmailAlreadyExistsView(requestModel.getEmail());
            return;
        }

        // Validate the email format
        if (!EmailValidator.isValid(requestModel.getEmail()))
        {
            presenter.prepareInvalidEmailFormatView(requestModel.getEmail());
            return;
        }


        // Validate the password
        try
        {
            PasswordValidator.isValid(requestModel.getPassword());
        } catch (IllegalArgumentException e)
        {
            presenter.prepareInvalidPasswordView(e.getMessage());
            return;
        }

        User newUser = userFactory.createUser(
                requestModel.getEmail(),
                requestModel.getUsername(),
                requestModel.getPassword()
        );

        userAuthDsGateway.save(newUser);

        // Prepare the success view
        presenter.prepareSuccessView(newUser);
    }
}
