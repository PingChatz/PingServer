package chat.ping.main.usecase;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.Messaging.AbstractMessage;
import chat.ping.main.entity.Messaging.MessageFactory;
import chat.ping.main.entity.user.User;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.infrastructure.messaging.gateway.messages.MessageGateway;
import chat.ping.main.infrastructure.messaging.gateway.threads.ThreadGateway;
import chat.ping.main.usecase.messaging.dto.MessageDTO;
import chat.ping.main.usecase.messaging.dto.SendMessageRequestModel;
import chat.ping.main.usecase.messaging.sendMessage.SendMessageInteractor;
import chat.ping.main.usecase.messaging.sendMessage.SendMessageOutputBoundary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class SendMessageInteractorTest
{

    private MessageGateway messageGateway;
    private ThreadGateway threadGateway;
    private UserAuthDsGateway userAuthDsGateway;
    private SendMessageOutputBoundary presenter;
    private MessageFactory messageFactory;
    private SendMessageInteractor interactor;

    @BeforeEach
    void setUp()
    {
        messageGateway = mock(MessageGateway.class);
        threadGateway = mock(ThreadGateway.class);
        userAuthDsGateway = mock(UserAuthDsGateway.class);
        presenter = mock(SendMessageOutputBoundary.class);
        messageFactory = new MessageFactory();
        interactor = new SendMessageInteractor(
                messageGateway, threadGateway, userAuthDsGateway, presenter, messageFactory
        );
    }

    @Test
    void testSendMessageSuccess()
    {
        // Arrange
        SendMessageRequestModel requestModel = new SendMessageRequestModel(
                1L, "user1", "text", "Hello!"
        );
        User user1 = new User("user1");
        MessageThread thread = new MessageThread(1L, "Test Thread");
        thread.setParticipants(Arrays.asList(user1));

        when(threadGateway.findThreadById(1L)).thenReturn(Optional.of(thread));
        when(userAuthDsGateway.findByUsername("user1")).thenReturn(Optional.of(user1));

        // Act
        interactor.sendMessage(requestModel);

        // Assert
        verify(messageGateway).saveMessage(any(AbstractMessage.class));
        verify(presenter).prepareSuccessView(any(MessageDTO.class));
    }

    @Test
    void testSendMessageThreadNotFound()
    {
        // Arrange
        SendMessageRequestModel requestModel = new SendMessageRequestModel(
                1L, "user1", "text", "Hello!"
        );
        when(threadGateway.findThreadById(1L)).thenReturn(Optional.empty());

        // Act
        interactor.sendMessage(requestModel);

        // Assert
        verify(presenter).prepareFailureView("Thread not found.");
        verify(messageGateway, never()).saveMessage(any(AbstractMessage.class));
    }

    @Test
    void testSendMessageSenderNotFound()
    {
        // Arrange
        SendMessageRequestModel requestModel = new SendMessageRequestModel(
                1L, "user1", "text", "Hello!"
        );
        MessageThread thread = new MessageThread(1L, "Test Thread");
        when(threadGateway.findThreadById(1L)).thenReturn(Optional.of(thread));
        when(userAuthDsGateway.findByUsername("user1")).thenReturn(Optional.empty());

        // Act
        interactor.sendMessage(requestModel);

        // Assert
        verify(presenter).prepareFailureView("Sender not found.");
        verify(messageGateway, never()).saveMessage(any(AbstractMessage.class));
    }
}
