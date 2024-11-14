package chat.ping.main.application.service;

import chat.ping.main.presentation.dto.MessageThreadResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ThreadService
{
    List<MessageThreadResponse> getMessageThreads(String userEmail);
}
