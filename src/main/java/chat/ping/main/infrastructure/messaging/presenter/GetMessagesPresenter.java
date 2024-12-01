package chat.ping.main.infrastructure.messaging.presenter;

import chat.ping.main.shared.error.ErrorResponse;
import chat.ping.main.usecase.messaging.dto.MessageDTO;
import chat.ping.main.usecase.messaging.getMessages.GetMessagesOutputBoundary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GetMessagesPresenter implements GetMessagesOutputBoundary
{
    private ResponseEntity<?> responseEntity;

    @Override
    public void prepareSuccessView(List<MessageDTO> messages)
    {
        this.responseEntity = ResponseEntity.status(HttpStatus.OK).body(Map.of("messages", messages));
    }


    @Override
    public void prepareFailureView(String errorMessage)
    {
        ErrorResponse errorResponse = new ErrorResponse("GetMessagesFailed", errorMessage);
        this.responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    public ResponseEntity<?> getResponseEntity()
    {
        return responseEntity;
    }
}
