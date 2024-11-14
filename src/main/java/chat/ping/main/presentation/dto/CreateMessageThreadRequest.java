package chat.ping.main.presentation.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Standard Way of Communication to create a new message thread.
 */
@Getter
@Setter
public class CreateMessageThreadRequest
{
    private String threadName;
    private List<String> participantUsernames;
}
