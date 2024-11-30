package chat.ping.main.infrastructure.messaging.presenter;

import chat.ping.main.shared.error.ErrorResponse;
import chat.ping.main.usecase.messaging.dto.ThreadDTO;
import chat.ping.main.usecase.messaging.getThreads.GetThreadOutputBoundary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetThreadsPresenter implements GetThreadOutputBoundary
{
    private ResponseEntity<?> responseEntity;

    @Override
    public void prepareSuccessView(List<ThreadDTO> threads)
    {
        this.responseEntity = ResponseEntity.status(HttpStatus.OK).body(threads);
    }

    @Override
    public void prepareFailureView(String errorMessage)
    {
        ErrorResponse errorResponse = new ErrorResponse("GetThreadsFailed", errorMessage);
        this.responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    public ResponseEntity<?> getResponseEntity()
    {
        return responseEntity;
    }
}
