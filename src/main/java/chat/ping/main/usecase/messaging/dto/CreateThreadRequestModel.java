package chat.ping.main.usecase.messaging.dto;

import java.util.List;

public class CreateThreadRequestModel
{
    private String threadName;
    private List<String> participants;

    // Constructors, getters, and setters
    public CreateThreadRequestModel()
    {
    }

    public CreateThreadRequestModel(String threadName, List<String> participants)
    {
        this.threadName = threadName;
        this.participants = participants;
    }

    public String getThreadName()
    {
        return threadName;
    }

    public List<String> getParticipants()
    {
        return participants;
    }
}
