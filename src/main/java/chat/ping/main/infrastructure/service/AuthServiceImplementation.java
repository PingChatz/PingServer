package chat.ping.main.infrastructure.service;

import chat.ping.main.application.service.AuthService;
import chat.ping.main.application.usecase.auth.LoginUseCase;
import chat.ping.main.presentation.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService
{
    private final LoginUseCase loginUseCase;

    @Override
    public ResponseEntity<?> login(LoginRequest loginRequest)
    {
        return loginUseCase.execute(loginRequest);
    }
}
