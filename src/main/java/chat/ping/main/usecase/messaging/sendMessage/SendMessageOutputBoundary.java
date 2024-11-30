package chat.ping.main.usecase.messaging.sendMessage;

import chat.ping.main.usecase.messaging.dto.MessageDTO;

public interface SendMessageOutputBoundary
{
    void prepareSuccessView(MessageDTO messageDTO);

    void prepareFailureView(String errorMessage);
}
