package chat.ping.main.presentation.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Object standardizing the request json structure.
 */
@Getter
@Setter
public class LoginRequest
{
    private String email;
    private String password;
}
