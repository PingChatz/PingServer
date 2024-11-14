package chat.ping.main.presentation.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The main model for the register API requests.
 * All register calls must have username, email and password.
 */
@Getter
@Setter
public class RegisterRequest
{
    private String username;
    private String email;
    private String password;
}
