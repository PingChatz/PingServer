package chat.ping.main.application.usecase.messaging;

import chat.ping.main.presentation.dto.SendMessageRequest;
import chat.ping.main.presentation.dto.SendMessageResponse;

public interface SendMessageUseCase
{
    SendMessageResponse execute(String userEmail, SendMessageRequest request);
}
