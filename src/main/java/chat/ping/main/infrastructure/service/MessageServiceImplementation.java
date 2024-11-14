package chat.ping.main.infrastructure.service;

import chat.ping.main.application.service.MessageService;
import chat.ping.main.application.usecase.messaging.SendMessageUseCase;
import chat.ping.main.presentation.dto.SendMessageRequest;
import chat.ping.main.presentation.dto.SendMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MessageServiceImplementation implements MessageService
{
    private final SendMessageUseCase sendMessageUseCase;

    public SendMessageResponse sendMessage(String userEmail, SendMessageRequest sendMessageRequest)
    {
        return sendMessageUseCase.execute(userEmail, sendMessageRequest);
    }
}
