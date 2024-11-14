package chat.ping.main.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMessageThreadResponse
{
    private Long newThreadId;
    private String newThreadName;

    public CreateMessageThreadResponse(Long newThreadId, String newThreadName)
    {
        this.newThreadName = newThreadName;
        this.newThreadId = newThreadId;
    }
}
