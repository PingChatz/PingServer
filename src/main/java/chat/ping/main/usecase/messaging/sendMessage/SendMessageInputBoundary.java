package chat.ping.main.usecase.messaging.sendMessage;

import chat.ping.main.usecase.messaging.dto.SendMessageRequestModel;

public interface SendMessageInputBoundary
{
    void sendMessage(SendMessageRequestModel requestModel);
}
