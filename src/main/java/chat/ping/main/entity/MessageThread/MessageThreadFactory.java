package chat.ping.main.entity.MessageThread;

import chat.ping.main.entity.user.User;

import java.util.List;

public class MessageThreadFactory
{
    public MessageThread createThread(String threadName, List<User> participants)
    {
        MessageThread thread = new MessageThread(null, threadName);
        thread.setParticipants(participants);
        return thread;
    }
}
