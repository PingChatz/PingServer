package chat.ping.main.infrastructure.security.exception;

public class InvalidTokenException extends RuntimeException
{
    public InvalidTokenException(String message)
    {
        super(message);
    }
}
