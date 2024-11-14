package chat.ping.main.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MessageDTO
{
    private Long MessageId;
    private String senderUsername;
    private Date timestamp;
    private String content;

    public MessageDTO(Long MessageId, String senderUsername, Date timestamp, String content)
    {
        this.MessageId = MessageId;
        this.senderUsername = senderUsername;
        this.timestamp = timestamp;
        this.content = content;
    }
}
