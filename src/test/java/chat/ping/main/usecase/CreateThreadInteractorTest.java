package chat.ping.main.usecase;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.MessageThread.MessageThreadFactory;
import chat.ping.main.entity.user.User;
import chat.ping.main.infrastructure.auth.gateway.UserAuthDsGateway;
import chat.ping.main.infrastructure.messaging.gateway.threads.ThreadGateway;
import chat.ping.main.usecase.messaging.createThreads.CreateThreadInteractor;
import chat.ping.main.usecase.messaging.createThreads.CreateThreadOutputBoundary;
import chat.ping.main.usecase.messaging.dto.CreateThreadRequestModel;
import chat.ping.main.usecase.messaging.dto.ThreadDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class CreateThreadInteractorTest
{

    private ThreadGateway threadGateway;
    private UserAuthDsGateway userAuthDsGateway;
    private CreateThreadOutputBoundary presenter;
    private MessageThreadFactory threadFactory;
    private CreateThreadInteractor interactor;

    @BeforeEach
    void setUp()
    {
        threadGateway = mock(ThreadGateway.class);
        userAuthDsGateway = mock(UserAuthDsGateway.class);
        presenter = mock(CreateThreadOutputBoundary.class);
        threadFactory = new MessageThreadFactory();
        interactor = new CreateThreadInteractor(threadGateway, userAuthDsGateway, presenter, threadFactory);
    }

    @Test
    void testCreateThreadSuccess()
    {
        // Arrange
        CreateThreadRequestModel requestModel = new CreateThreadRequestModel(
                "Test Thread", Arrays.asList("user1", "user2")
        );
        User user1 = new User("user1");
        User user2 = new User("user2");

        when(userAuthDsGateway.findByUsername("user1")).thenReturn(Optional.of(user1));
        when(userAuthDsGateway.findByUsername("user2")).thenReturn(Optional.of(user2));

        // Act
        interactor.createThread(requestModel);

        // Assert
        verify(threadGateway).saveThread(any(MessageThread.class));
        verify(presenter).prepareSuccessView(any(ThreadDTO.class));
    }

    @Test
    void testCreateThreadUserNotFound()
    {
        // Arrange
        CreateThreadRequestModel requestModel = new CreateThreadRequestModel(
                "Test Thread", Arrays.asList("user1", "nonexistentuser")
        );
        User user1 = new User("user1");

        when(userAuthDsGateway.findByUsername("user1")).thenReturn(Optional.of(user1));
        when(userAuthDsGateway.findByUsername("nonexistentuser")).thenReturn(Optional.empty());

        // Act
        interactor.createThread(requestModel);

        // Assert
        verify(presenter).prepareFailureView("One or more participants do not exist.");
        verify(threadGateway, never()).saveThread(any(MessageThread.class));
    }
}
