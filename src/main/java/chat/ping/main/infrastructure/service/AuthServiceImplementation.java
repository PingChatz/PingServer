package chat.ping.main.infrastructure.service;

import chat.ping.main.application.service.AuthService;
import chat.ping.main.application.usecase.auth.LoginUseCase;
import chat.ping.main.application.usecase.auth.RegisterUseCase;
import chat.ping.main.presentation.dto.LoginRequest;
import chat.ping.main.presentation.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * The implementation of the Auth Service
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService
{
    private final RegisterUseCase registerUseCase;
    private final LoginUseCase loginUseCase;

    @Override
    public ResponseEntity<?> register(final RegisterRequest registerRequest)
    {
        return registerUseCase.execute(registerRequest);
    }

    @Override
    public ResponseEntity<?> login(final LoginRequest loginRequest)
    {
        return loginUseCase.execute(loginRequest);
    }
}
