package chat.ping.main.entity.Messaging;

import chat.ping.main.entity.MessageThread.MessageThread;
import chat.ping.main.entity.user.User;

public class TextMessage extends AbstractMessage
{
    private String content;

    public TextMessage(MessageThread messageThread,
                       User sender,
                       String content)
    {
        super(messageThread, sender);
        this.content = content;
    }




    @Override
    public String getContent()
    {
        return content;
    }
}
