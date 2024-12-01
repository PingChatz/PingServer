package chat.ping.main.usecase;

import chat.ping.main.entity.user.User;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.infrastructure.security.JWTUtils;
import chat.ping.main.usecase.auth.dto.UserLoginRequestModel;
import chat.ping.main.usecase.auth.login.UserLoginInteractor;
import chat.ping.main.usecase.auth.login.UserLoginOutputBoundary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.*;

public class UserLoginInteractorTest
{

    private UserAuthDsGateway userAuthDsGateway;
    private UserLoginOutputBoundary presenter;
    private JWTUtils jwtUtils;
    private BCryptPasswordEncoder passwordEncoder;
    private UserLoginInteractor interactor;

    @BeforeEach
    void setUp()
    {
        userAuthDsGateway = mock(UserAuthDsGateway.class);
        presenter = mock(UserLoginOutputBoundary.class);
        jwtUtils = mock(JWTUtils.class);
        passwordEncoder = new BCryptPasswordEncoder();
        interactor = new UserLoginInteractor(userAuthDsGateway, passwordEncoder, presenter, jwtUtils);
    }

    @Test
    void testLoginSuccess()
    {
        // Arrange
        User user = new User("test@example.com", "testuser", passwordEncoder.encode("ValidPass1!"));
        when(userAuthDsGateway.findByUsername("testuser")).thenReturn(java.util.Optional.of(user));
        when(jwtUtils.generateToken(eq("testuser"), anyMap())).thenReturn("token");

        UserLoginRequestModel requestModel = new UserLoginRequestModel("testuser", "ValidPass1!");

        // Act
        interactor.login(requestModel);

        // Assert
        verify(presenter).prepareSuccessView("token", "testuser");
    }

    @Test
    void testLoginInvalidCredentials()
    {
        // Arrange
        when(userAuthDsGateway.findByUsername("testuser")).thenReturn(java.util.Optional.empty());

        UserLoginRequestModel requestModel = new UserLoginRequestModel("testuser", "WrongPass");

        // Act
        interactor.login(requestModel);

        // Assert
        verify(presenter).prepareInvalidCredentialsView("Invalid username/email or password.");
    }

    @Test
    void testLoginInvalidPassword()
    {
        // Arrange
        User user = new User("test@example.com", "testuser", passwordEncoder.encode("ValidPass1!"));
        when(userAuthDsGateway.findByUsername("testuser")).thenReturn(java.util.Optional.of(user));

        UserLoginRequestModel requestModel = new UserLoginRequestModel("testuser", "WrongPass");

        // Act
        interactor.login(requestModel);

        // Assert
        verify(presenter).prepareInvalidCredentialsView("Invalid username/email or password.");
    }
}
