package chat.ping.main.application.usecase.auth.implimentations;

import chat.ping.main.application.usecase.auth.LoginUseCase;
import chat.ping.main.domain.models.User;
import chat.ping.main.domain.repositories.UserRepository;
import chat.ping.main.infrastructure.JWTUtils;
import chat.ping.main.presentation.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class LoginUseCaseImplementation implements LoginUseCase
{
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JWTUtils jwtUtils;
    private final UserDetailsService userDetailsService;

    @Override
    public ResponseEntity<?> execute(LoginRequest loginRequest)
    {
        // Set Up the authentication manager and authenticate user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        // Load UserDetails
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        // Generate new token for user
        String jwtToken = jwtUtils.generateToken(userDetails, Map.of());

        // Return the token in a JSON format with "auth_token" as the key
        Map<String, String> response = Map.of("auth_token", jwtToken);
        return ResponseEntity.ok(response);
    }
}
