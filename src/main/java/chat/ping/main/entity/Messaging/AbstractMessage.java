package chat.ping.main.entity.Messaging;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.user.User;

import java.util.Date;

public abstract class AbstractMessage
{
    private Long messageId;
    private User sender;
    private MessageThread thread;
    private Date timestamp;

    public AbstractMessage(MessageThread thread, User sender)
    {
        this.sender = sender;
        this.thread = thread;
        this.timestamp = new Date(); // Defaults to current timestamp
    }

    public Long getMessageId()
    {
        return messageId;
    }

    public void setMessageId(Long messageId)
    {
        this.messageId = messageId;
    }

    public User getSender()
    {
        return sender;
    }

    public MessageThread getThread()
    {
        return thread;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public abstract String getContent();
}
