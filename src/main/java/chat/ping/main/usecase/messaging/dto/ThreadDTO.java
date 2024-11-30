package chat.ping.main.usecase.messaging.dto;

import java.util.List;

public class ThreadDTO
{
    private Long threadId;
    private String threadName;
    private List<String> participants;

    // Getters and Setters
    public Long getThreadId()
    {
        return threadId;
    }

    public void setThreadId(Long threadId)
    {
        this.threadId = threadId;
    }

    public String getThreadName()
    {
        return threadName;
    }

    public void setThreadName(String threadName)
    {
        this.threadName = threadName;
    }

    public List<String> getParticipants()
    {
        return participants;
    }

    public void setParticipants(List<String> participants)
    {
        this.participants = participants;
    }
}
