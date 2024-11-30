package chat.ping.main.usecase.messaging.getThreads;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.infrastructure.messaging.gateway.threads.ThreadGateway;
import chat.ping.main.usecase.messaging.dto.ThreadDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GetThreadsInteractor implements GetThreadsInputBoundary
{
    private final ThreadGateway threadGateway;
    private final GetThreadOutputBoundary presenter;

    public GetThreadsInteractor(ThreadGateway threadGateway, GetThreadOutputBoundary presenter)
    {
        this.threadGateway = threadGateway;
        this.presenter = presenter;
    }

    @Override
    public void getThreads(String username)
    {
        List<MessageThread> threads = threadGateway.findThreadsByUsername(username);

        List<ThreadDTO> threadDTOs = threads.stream().map(thread ->
        {
            ThreadDTO dto = new ThreadDTO();
            dto.setThreadId(thread.getThreadID());
            dto.setThreadName(thread.getThreadName());
            dto.setParticipants(thread.getParticipants().stream().map(user -> user.getUsername()).collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());

        presenter.prepareSuccessView(username, threadDTOs);
    }
}
