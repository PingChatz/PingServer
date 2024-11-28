package chat.ping.main.application.service;

import chat.ping.main.presentation.dto.LoginRequest;
import chat.ping.main.presentation.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;


public interface AuthService
{
    // Register
    ResponseEntity<?> register(RegisterRequest registerRequest);
    // Login
    ResponseEntity<?> login(LoginRequest loginRequest);
}
