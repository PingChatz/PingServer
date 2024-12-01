package chat.ping.main.entity.MessageThread;

import chat.ping.main.entity.Messaging.AbstractMessage;
import chat.ping.main.entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class MessageThread
{
    private Long threadID;
    private String threadName;
    private List<User> participants = new ArrayList<>();
    private List<AbstractMessage> messages = new ArrayList<>();

    public MessageThread(Long threadID, String threadName)
    {
        this.threadID = threadID;
        this.threadName = threadName;
    }

    public Long getThreadID()
    {
        return threadID;
    }

    public void setThreadID(Long threadID)
    {
        this.threadID = threadID;
    }

    public String getThreadName()
    {
        return threadName;
    }

    public void setThreadName(String threadName)
    {
        this.threadName = threadName;
    }

    public List<User> getParticipants()
    {
        return participants;
    }

    public void setParticipants(List<User> participants)
    {
        this.participants = participants;
    }

    public List<AbstractMessage> getMessages()
    {
        return messages;
    }

    public void addMessage(AbstractMessage message)
    {
        this.messages.add(message);
    }

    public void addParticipant(User user)
    {
        this.participants.add(user);
    }
}
