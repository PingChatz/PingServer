package chat.ping.main.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageRequest
{
    private Long threadId;
    private String messageType;
    private String content;
}
