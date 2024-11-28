package chat.ping.main.entity.user.exception;

public class InvalidPasswordException extends RuntimeException
{
    public InvalidPasswordException(String message)
    {
        super(message);
    }
}
