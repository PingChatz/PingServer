package chat.ping.main.application.service;

import chat.ping.main.presentation.dto.MessageDTO;
import chat.ping.main.presentation.dto.SendMessageRequest;
import chat.ping.main.presentation.dto.SendMessageResponse;

import java.util.List;

public interface MessageService
{
    SendMessageResponse sendMessage(String userEmail, SendMessageRequest sendMessageRequest);

    List<MessageDTO> getMessages(String userEmail, Long theadId, int limit);
}
