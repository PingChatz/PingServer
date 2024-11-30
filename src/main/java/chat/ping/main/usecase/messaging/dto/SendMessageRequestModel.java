package chat.ping.main.usecase.messaging.dto;

public class SendMessageRequestModel
{
    private Long threadId;
    private String senderUsername;
    private String messageType;
    private String content;

    // Constructors, getters, and setters
    public SendMessageRequestModel()
    {
    }

    public SendMessageRequestModel(Long threadId, String senderUsername, String messageType, String content)
    {
        this.threadId = threadId;
        this.senderUsername = senderUsername;
        this.messageType = messageType;
        this.content = content;
    }


    public Long getThreadId()
    {
        return threadId;
    }

    public String getSenderUsername()
    {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername)
    {
        this.senderUsername = senderUsername;
    }

    public String getContent()
    {
        return content;
    }

    public String getMessageType()
    {
        return messageType;
    }
}
