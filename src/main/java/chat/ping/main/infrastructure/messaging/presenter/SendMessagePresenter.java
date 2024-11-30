package chat.ping.main.infrastructure.messaging.presenter;

import chat.ping.main.shared.error.ErrorResponse;
import chat.ping.main.usecase.messaging.sendMessage.SendMessageOutputBoundary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SendMessagePresenter implements SendMessageOutputBoundary
{
    private ResponseEntity<?> responseEntity;

    @Override
    public void prepareSuccessView()
    {
        Map<String, String> response = Map.of("message", "Message sent successfully.");
        this.responseEntity = ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public void prepareFailureView(String errorMessage)
    {
        ErrorResponse errorResponse = new ErrorResponse("SendMessageFailed", errorMessage);
        this.responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    public ResponseEntity<?> getResponseEntity()
    {
        return responseEntity;
    }
}
