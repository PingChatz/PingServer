package chat.ping.main.application.usecase.thread;

import chat.ping.main.presentation.dto.MessageThreadResponse;

import java.util.List;

/**
 * Interface to collect List of Message Threads.
 */
public interface GetMessageThreadsUserCase
{
    List<MessageThreadResponse> execute(String userEmail);
}
