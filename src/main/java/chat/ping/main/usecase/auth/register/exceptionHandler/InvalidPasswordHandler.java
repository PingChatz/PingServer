package chat.ping.main.usecase.auth.register.exceptionHandler;


import chat.ping.main.entity.user.exception.InvalidCredentialsException;
import chat.ping.main.entity.user.exception.InvalidPasswordException;
import chat.ping.main.shared.error.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class InvalidPasswordHandler
{
    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPasswordException(InvalidPasswordException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse(
                "Invalid Password",
                ex.getMessage(),
                HttpStatus.UNAUTHORIZED.value()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
