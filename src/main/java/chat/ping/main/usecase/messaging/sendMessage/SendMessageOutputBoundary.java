package chat.ping.main.usecase.messaging.sendMessage;

public interface SendMessageOutputBoundary
{
    void prepareSuccessView();

    void prepareFailureView(String errorMessage);
}
