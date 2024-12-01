package chat.ping.main.usecase.messaging.getMessages;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.Messaging.AbstractMessage;
import chat.ping.main.infrastructure.messaging.gateway.messages.MessageGateway;
import chat.ping.main.infrastructure.messaging.gateway.threads.ThreadGateway;
import chat.ping.main.usecase.messaging.dto.MessageDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GetMessageInteractor implements GetMessagesInputBoundary
{
    private final MessageGateway messageGateway;
    private final ThreadGateway threadGateway;
    private final GetMessagesOutputBoundary presenter;

    public GetMessageInteractor(MessageGateway messageGateway, ThreadGateway threadGateway, GetMessagesOutputBoundary presenter)
    {
        this.messageGateway = messageGateway;
        this.threadGateway = threadGateway;
        this.presenter = presenter;
    }

    @Override
    public void getMessages(Long threadId, String username)
    {
        MessageThread thread = threadGateway.findThreadById(threadId)
                .orElse(null);

        if (thread == null)
        {
            presenter.prepareFailureView("Thread not found.");
            return;
        }

        boolean isParticipant = thread.getParticipants().stream()
                .anyMatch(user -> user.getUsername().equals(username));

        if (!isParticipant)
        {
            presenter.prepareFailureView("User is not a participant in this thread.");
            return;
        }

        List<AbstractMessage> messages = messageGateway.getMessagesForThread(threadId);

        List<MessageDTO> messageDTOs = messages.stream().map(message ->
        {
            MessageDTO dto = new MessageDTO();
            dto.setMessageId(message.getMessageId());
            dto.setSender(message.getSender().getUsername());
            dto.setContent(message.getContent());
            dto.setTimestamp(message.getTimestamp());
            return dto;
        }).collect(Collectors.toList());

        presenter.prepareSuccessView(messageDTOs);
    }
}
