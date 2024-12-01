package chat.ping.main.infrastructure.messaging.presenter;

import chat.ping.main.shared.error.ErrorResponse;
import chat.ping.main.usecase.messaging.dto.ThreadDTO;
import chat.ping.main.usecase.messaging.getThreads.GetThreadOutputBoundary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GetThreadsPresenter implements GetThreadOutputBoundary
{
    private ResponseEntity<?> responseEntity;

    @Override
    public void prepareSuccessView(String username, List<ThreadDTO> threads)
    {
        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("threads", threads);
        this.responseEntity = ResponseEntity.status(HttpStatus.OK).body(response);
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

