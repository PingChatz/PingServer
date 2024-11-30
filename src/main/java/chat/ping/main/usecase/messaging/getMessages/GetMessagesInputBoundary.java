package chat.ping.main.usecase.messaging.getMessages;

public interface GetMessagesInputBoundary
{
    void getMessages(Long threadId, String username);
}
