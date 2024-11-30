package chat.ping.main.usecase;

import chat.ping.main.entity.user.User;
import chat.ping.main.entity.user.UserFactory;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.usecase.auth.dto.UserRegisterRequestModel;
import chat.ping.main.usecase.auth.register.UserRegisterInteractor;
import chat.ping.main.usecase.auth.register.UserRegisterOutputBoundary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.*;

public class UserRegisterInteractorTest
{

    private UserAuthDsGateway userAuthDsGateway;
    private UserRegisterOutputBoundary presenter;
    private UserFactory userFactory;
    private UserRegisterInteractor interactor;

    @BeforeEach
    void setUp()
    {
        userAuthDsGateway = mock(UserAuthDsGateway.class);
        presenter = mock(UserRegisterOutputBoundary.class);
        userFactory = new UserFactory(new BCryptPasswordEncoder());
        interactor = new UserRegisterInteractor(userAuthDsGateway, presenter, userFactory);
    }

    @Test
    void testRegisterSuccess()
    {
        // Arrange
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                "newuser", "ValidPass1!", "newuser@example.com"
        );
        when(userAuthDsGateway.existsByUsername("newuser")).thenReturn(false);
        when(userAuthDsGateway.existsByEmail("newuser@example.com")).thenReturn(false);

        // Act
        interactor.register(requestModel);

        // Assert
        verify(presenter).prepareSuccessView(any(User.class));
        verify(userAuthDsGateway).save(any(User.class));
    }

    @Test
    void testRegisterUsernameExists()
    {
        // Arrange
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                "existinguser", "ValidPass1!", "newuser@example.com"
        );
        when(userAuthDsGateway.existsByUsername("existinguser")).thenReturn(true);

        // Act
        interactor.register(requestModel);

        // Assert
        verify(presenter).prepareUsernameAlreadyExistsView("existinguser");
        verify(userAuthDsGateway, never()).save(any(User.class));
    }

    @Test
    void testRegisterInvalidEmailFormat()
    {
        // Arrange
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                "newuser", "ValidPass1!", "invalidemail"
        );
        when(userAuthDsGateway.existsByUsername("newuser")).thenReturn(false);

        // Act
        interactor.register(requestModel);

        // Assert
        verify(presenter).prepareInvalidEmailFormatView("invalidemail");
        verify(userAuthDsGateway, never()).save(any(User.class));
    }

    @Test
    void testRegisterInvalidPassword()
    {
        // Arrange
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                "newuser", "short", "newuser@example.com"
        );
        when(userAuthDsGateway.existsByUsername("newuser")).thenReturn(false);
        when(userAuthDsGateway.existsByEmail("newuser@example.com")).thenReturn(false);

        // Act
        interactor.register(requestModel);

        // Assert
        verify(presenter).prepareInvalidPasswordView(anyString());
        verify(userAuthDsGateway, never()).save(any(User.class));
    }
}
