package chat.ping.main.application.service;

import chat.ping.main.presentation.dto.CreateMessageThreadRequest;
import chat.ping.main.presentation.dto.CreateMessageThreadResponse;
import chat.ping.main.presentation.dto.MessageThreadResponse;

import java.util.List;

public interface ThreadService
{
    List<MessageThreadResponse> getMessageThreads(String userEmail);

    CreateMessageThreadResponse createMessageThread(String user_email, CreateMessageThreadRequest createMessageThreadRequest);
}
