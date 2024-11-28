package chat.ping.main.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SendMessageResponse
{
    private String message;
    private Date timeStamp;

    public SendMessageResponse(Date timeStamp, String message)
    {
        this.timeStamp = timeStamp;
        this.message = message;
    }
}
