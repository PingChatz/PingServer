package chat.ping.main.usecase.messaging.createThreads;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.MessageThread.MessageThreadFactory;
import chat.ping.main.entity.user.User;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.infrastructure.messaging.gateway.threads.ThreadGateway;
import chat.ping.main.usecase.messaging.dto.CreateThreadRequestModel;
import chat.ping.main.usecase.messaging.dto.ThreadDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CreateThreadInteractor implements CreateThreadInputBoundary
{
    private final ThreadGateway threadGateway;
    private final UserAuthDsGateway userAuthDsGateway;
    private final CreateThreadOutputBoundary presenter;
    private final MessageThreadFactory threadFactory;

    public CreateThreadInteractor(ThreadGateway threadGateway,
                                  UserAuthDsGateway userAuthDsGateway,
                                  CreateThreadOutputBoundary presenter,
                                  MessageThreadFactory threadFactory)
    {
        this.threadGateway = threadGateway;
        this.userAuthDsGateway = userAuthDsGateway;
        this.presenter = presenter;
        this.threadFactory = threadFactory;
    }

    @Override
    public void createThread(CreateThreadRequestModel requestModel)
    {
        // Validate participants
        List<User> participants = requestModel.getParticipants().stream()
                .map(username -> userAuthDsGateway.findByUsername(username).orElse(null))
                .collect(Collectors.toList());

        if (participants.contains(null))
        {
            presenter.prepareFailureView("One or more participants do not exist.");
            return;
        }

        // Create thread
        MessageThread thread = threadFactory.createThread(requestModel.getThreadName(), participants);
        threadGateway.saveThread(thread);

        // Prepare success view
        ThreadDTO threadDTO = new ThreadDTO();
        threadDTO.setThreadId(thread.getThreadID());
        threadDTO.setThreadName(thread.getThreadName());
        threadDTO.setParticipants(participants.stream().map(User::getUsername).collect(Collectors.toList()));

        presenter.prepareSuccessView(threadDTO);
    }
}
