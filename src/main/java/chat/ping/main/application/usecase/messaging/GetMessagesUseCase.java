package chat.ping.main.application.usecase.messaging;


import chat.ping.main.presentation.dto.GetMessagesRequest;
import chat.ping.main.presentation.dto.MessageDTO;

import java.util.List;

public interface GetMessagesUseCase
{
    List<MessageDTO> execute(String userEmail, Long threadId, int limit);
}
