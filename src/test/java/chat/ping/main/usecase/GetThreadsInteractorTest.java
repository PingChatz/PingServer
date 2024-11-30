package chat.ping.main.usecase;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.user.User;
import chat.ping.main.infrastructure.messaging.gateway.threads.ThreadGateway;
import chat.ping.main.usecase.messaging.getThreads.GetThreadOutputBoundary;
import chat.ping.main.usecase.messaging.getThreads.GetThreadsInteractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class GetThreadsInteractorTest
{

    private ThreadGateway threadGateway;
    private GetThreadOutputBoundary presenter;
    private GetThreadsInteractor interactor;

    @BeforeEach
    void setUp()
    {
        threadGateway = mock(ThreadGateway.class);
        presenter = mock(GetThreadOutputBoundary.class);
        interactor = new GetThreadsInteractor(threadGateway, presenter);
    }

    @Test
    void testGetThreadsSuccess()
    {
        // Arrange
        User user1 = new User("user1");
        User user2 = new User("user2");

        MessageThread thread1 = new MessageThread(1L, "Thread 1");
        thread1.setParticipants(Arrays.asList(user1, user2));

        when(threadGateway.findThreadsByUsername("user1")).thenReturn(Arrays.asList(thread1));

        // Act
        interactor.getThreads("user1");

        // Assert
        verify(presenter).prepareSuccessView(eq("user1"), anyList());
    }
}

