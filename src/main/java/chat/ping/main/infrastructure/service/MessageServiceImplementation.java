package chat.ping.main.infrastructure.service;

import chat.ping.main.application.service.MessageService;
import chat.ping.main.application.usecase.messaging.GetMessagesUseCase;
import chat.ping.main.application.usecase.messaging.SendMessageUseCase;
import chat.ping.main.presentation.dto.MessageDTO;
import chat.ping.main.presentation.dto.SendMessageRequest;
import chat.ping.main.presentation.dto.SendMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MessageServiceImplementation implements MessageService
{
    private final SendMessageUseCase sendMessageUseCase;
    private final GetMessagesUseCase getMessagesUseCase;

    @Override
    public SendMessageResponse sendMessage(String userEmail, SendMessageRequest sendMessageRequest)
    {
        return sendMessageUseCase.execute(userEmail, sendMessageRequest);
    }

    @Override
    public List<MessageDTO> getMessages(String userEmail, Long theadId, int limit)
    {
        return getMessagesUseCase.execute(userEmail, theadId, limit);
    }
}
