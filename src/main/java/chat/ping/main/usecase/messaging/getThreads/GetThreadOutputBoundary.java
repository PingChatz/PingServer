package chat.ping.main.usecase.messaging.getThreads;

import chat.ping.main.usecase.messaging.dto.ThreadDTO;

import java.util.List;

public interface GetThreadOutputBoundary
{
    void prepareSuccessView(List<ThreadDTO> threads);

    void prepareFailureView(String errorMessage);
}
