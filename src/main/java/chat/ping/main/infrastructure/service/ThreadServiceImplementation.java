package chat.ping.main.infrastructure.service;


import chat.ping.main.application.service.ThreadService;
import chat.ping.main.application.usecase.thread.GetMessageThreadsUserCase;
import chat.ping.main.presentation.dto.MessageThreadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThreadServiceImplementation implements ThreadService
{
    private final GetMessageThreadsUserCase getMessageThreadsUserCase;


    @Override
    public List<MessageThreadResponse> getMessageThreads(String userEmail)
    {
        return getMessageThreadsUserCase.execute(userEmail);
    }

}
