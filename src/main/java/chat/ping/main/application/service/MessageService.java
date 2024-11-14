package chat.ping.main.application.service;

import chat.ping.main.presentation.dto.SendMessageRequest;
import chat.ping.main.presentation.dto.SendMessageResponse;

public interface MessageService
{
    SendMessageResponse sendMessage(String userEmail, SendMessageRequest sendMessageRequest);
}
