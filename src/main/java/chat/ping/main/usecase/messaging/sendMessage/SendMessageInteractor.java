package chat.ping.main.usecase.messaging.sendMessage;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.Messaging.AbstractMessage;
import chat.ping.main.entity.Messaging.MessageFactory;
import chat.ping.main.entity.user.User;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.infrastructure.messaging.gateway.messages.MessageGateway;
import chat.ping.main.infrastructure.messaging.gateway.threads.ThreadGateway;
import chat.ping.main.usecase.messaging.dto.MessageDTO;
import chat.ping.main.usecase.messaging.dto.SendMessageRequestModel;

public class SendMessageInteractor implements SendMessageInputBoundary
{
    private final MessageGateway messageGateway;
    private final ThreadGateway threadGateway;
    private final UserAuthDsGateway userAuthDsGateway;
    private final SendMessageOutputBoundary presenter;
    private final MessageFactory messageFactory;

    public SendMessageInteractor(MessageGateway messageGateway,
                                 ThreadGateway threadGateway,
                                 UserAuthDsGateway userAuthDsGateway,
                                 SendMessageOutputBoundary presenter,
                                 MessageFactory messageFactory)
    {
        this.messageGateway = messageGateway;
        this.threadGateway = threadGateway;
        this.userAuthDsGateway = userAuthDsGateway;
        this.presenter = presenter;
        this.messageFactory = messageFactory;
    }

    @Override
    public void sendMessage(SendMessageRequestModel requestModel)
    {
        MessageThread thread = threadGateway.findThreadById(requestModel.getThreadId())
                .orElse(null);

        if (thread == null)
        {
            presenter.prepareFailureView("Thread not found.");
            return;
        }

        User sender = userAuthDsGateway.findByUsername(requestModel.getSenderUsername())
                .orElse(null);

        if (sender == null)
        {
            presenter.prepareFailureView("Sender not found.");
            return;
        }

        boolean isParticipant = thread.getParticipants().stream()
                .anyMatch(user -> user.getUsername().equals(sender.getUsername()));

        if (!isParticipant)
        {
            presenter.prepareFailureView("Sender is not a participant in this thread.");
            return;
        }

        // Create message based on messageType
        AbstractMessage message;
        if ("text".equalsIgnoreCase(requestModel.getMessageType()))
        {
            message = messageFactory.createTextMessage(requestModel.getContent(), sender, thread);
        } else
        {
            presenter.prepareFailureView("Unsupported message type.");
            return;
        }

        messageGateway.saveMessage(message);

        // Prepare MessageDTO
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessageId(message.getMessageId());
        messageDTO.setSender(message.getSender().getUsername());
        messageDTO.setContent(message.getContent());
        messageDTO.setTimestamp(message.getTimestamp());

        presenter.prepareSuccessView(messageDTO);
    }
}
