package chat.ping.main.usecase.messaging.getMessages;

import chat.ping.main.usecase.messaging.dto.MessageDTO;

import java.util.List;

public interface GetMessagesOutputBoundary
{
    void prepareSuccessView(List<MessageDTO> messages);

    void prepareFailureView(String errorMessage);
}
