package chat.ping.main.usecase;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.Messaging.TextMessage;
import chat.ping.main.entity.user.User;
import chat.ping.main.infrastructure.messaging.gateway.messages.MessageGateway;
import chat.ping.main.infrastructure.messaging.gateway.threads.ThreadGateway;
import chat.ping.main.usecase.messaging.getMessages.GetMessageInteractor;
import chat.ping.main.usecase.messaging.getMessages.GetMessagesOutputBoundary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class GetMessageInteractorTest
{

    private MessageGateway messageGateway;
    private ThreadGateway threadGateway;
    private GetMessagesOutputBoundary presenter;
    private GetMessageInteractor interactor;

    @BeforeEach
    void setUp()
    {
        messageGateway = mock(MessageGateway.class);
        threadGateway = mock(ThreadGateway.class);
        presenter = mock(GetMessagesOutputBoundary.class);
        interactor = new GetMessageInteractor(messageGateway, threadGateway, presenter);
    }

    @Test
    void testGetMessagesSuccess()
    {
        // Arrange
        User user = new User("user1");
        MessageThread thread = new MessageThread(1L, "Test Thread");
        thread.setParticipants(Arrays.asList(user));

        TextMessage message = new TextMessage(thread, user, "Hello!");
        message.setMessageId(1L);

        when(threadGateway.findThreadById(1L)).thenReturn(Optional.of(thread));
        when(messageGateway.getMessagesForThread(1L)).thenReturn(Arrays.asList(message));

        // Act
        interactor.getMessages(1L, "user1");

        // Assert
        verify(presenter).prepareSuccessView(anyList());
    }

    @Test
    void testGetMessagesThreadNotFound()
    {
        // Arrange
        when(threadGateway.findThreadById(1L)).thenReturn(Optional.empty());

        // Act
        interactor.getMessages(1L, "user1");

        // Assert
        verify(presenter).prepareFailureView("Thread not found.");
    }

    @Test
    void testGetMessagesUserNotParticipant()
    {
        // Arrange
        User user = new User("user1");
        MessageThread thread = new MessageThread(1L, "Test Thread");
        thread.setParticipants(Arrays.asList(new User("user2")));

        when(threadGateway.findThreadById(1L)).thenReturn(Optional.of(thread));

        // Act
        interactor.getMessages(1L, "user1");

        // Assert
        verify(presenter).prepareFailureView("User is not a participant in this thread.");
    }
}
