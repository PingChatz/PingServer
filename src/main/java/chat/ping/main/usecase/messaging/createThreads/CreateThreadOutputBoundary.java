package chat.ping.main.usecase.messaging.createThreads;

import chat.ping.main.usecase.messaging.dto.ThreadDTO;

public interface CreateThreadOutputBoundary
{
    void prepareSuccessView(ThreadDTO threadDTO);

    void prepareFailureView(String errorMessage);
}
