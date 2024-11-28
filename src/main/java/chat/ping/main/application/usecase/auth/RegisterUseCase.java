package chat.ping.main.application.usecase.auth;


import chat.ping.main.presentation.dto.LoginRequest;
import chat.ping.main.presentation.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;

/**
 * Register use-case is the interface that the code interacts with in order to process user registration.
 */
public interface RegisterUseCase
{
    ResponseEntity<?> execute(RegisterRequest registerRequest);
}
