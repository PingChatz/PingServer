package chat.ping.main.application.usecase.thread;


import chat.ping.main.presentation.dto.CreateMessageThreadRequest;
import chat.ping.main.presentation.dto.CreateMessageThreadResponse;

public interface CreateMessageThreadUseCase
{
    CreateMessageThreadResponse execute(String userEmail, CreateMessageThreadRequest request);
}
