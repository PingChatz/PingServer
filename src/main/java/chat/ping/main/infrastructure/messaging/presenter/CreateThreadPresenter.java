package chat.ping.main.infrastructure.messaging.presenter;

import chat.ping.main.shared.error.ErrorResponse;
import chat.ping.main.usecase.messaging.createThreads.CreateThreadOutputBoundary;
import chat.ping.main.usecase.messaging.dto.ThreadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateThreadPresenter implements CreateThreadOutputBoundary
{
    private ResponseEntity<?> responseEntity;

    @Override
    public void prepareSuccessView(ThreadDTO threadDTO)
    {
        this.responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(threadDTO);
    }

    @Override
    public void prepareFailureView(String errorMessage)
    {
        ErrorResponse errorResponse = new ErrorResponse("CreateThreadFailed", errorMessage);
        this.responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    public ResponseEntity<?> getResponseEntity()
    {
        return responseEntity;
    }
}
