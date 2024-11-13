package chat.ping.main.application.service;

import chat.ping.main.presentation.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface AuthService
{
    ResponseEntity<?> login(LoginRequest loginRequest);
}
