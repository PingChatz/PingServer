package chat.ping.main.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageThreadResponse
{
    private Long threadId;
    private String threadName;

    // Constructor
    public MessageThreadResponse(final Long threadId, final String threadName)
    {
        this.threadId = threadId;
        this.threadName = threadName;
    }
}
