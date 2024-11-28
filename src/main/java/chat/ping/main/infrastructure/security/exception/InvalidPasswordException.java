package chat.ping.main.infrastructure.security.exception;

public class InvalidPasswordException extends RuntimeException
{
    public InvalidPasswordException(String message) {
        super(message);
    }
}
