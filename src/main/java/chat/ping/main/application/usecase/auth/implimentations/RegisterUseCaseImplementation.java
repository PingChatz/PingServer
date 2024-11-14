package chat.ping.main.application.usecase.auth.implimentations;


import chat.ping.main.application.usecase.auth.RegisterUseCase;
import chat.ping.main.domain.models.User;
import chat.ping.main.domain.repositories.UserRepository;
import chat.ping.main.presentation.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * The implementation of the Register Use case to add a user to the system.
 */
@Component
@RequiredArgsConstructor
public class RegisterUseCaseImplementation implements RegisterUseCase
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> execute(RegisterRequest registerRequest)
    {
        // Make sure email is unique
        if (userRepository.existsByEmail(registerRequest.getEmail()))
        {
            return ResponseEntity.badRequest().body("Email is already in use");
        }

        // make sure username is unique
        if (userRepository.existsByUsername(registerRequest.getUsername()))
        {
            return ResponseEntity.badRequest().body("Username is already in use");
        }

        // If so create a new user
        User user = new User(
                registerRequest.getUsername(),
                registerRequest.getEmail(),
                passwordEncoder.encode(registerRequest.getPassword())
        );

        // Save user to the repository
        userRepository.save(user);

        // return response
        return ResponseEntity.ok("User registered successfully");
    }
}
