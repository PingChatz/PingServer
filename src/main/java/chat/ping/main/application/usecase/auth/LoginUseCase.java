package chat.ping.main.application.usecase.auth;

import chat.ping.main.presentation.dto.LoginRequest;
import org.springframework.http.ResponseEntity;

/**
 * Interface to be used by infrastructure layer for Login Use Case.
 */
public interface LoginUseCase
{
    ResponseEntity<?> execute(LoginRequest loginRequest);
}
