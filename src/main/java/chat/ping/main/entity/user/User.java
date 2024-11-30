package chat.ping.main.entity.user;

import chat.ping.main.entity.MessageThread.MessageThread;

import java.util.ArrayList;
import java.util.List;

public class User
{

    // properties
    private final String email;
    private final String username;
    private final String passwordHash;

    private List<MessageThread> messageThreadList = new ArrayList<>();

    // Constructor
    public User(String email, String username, String passwordHash)
    {
        this.email = email;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    // Additional constructor
    public User(String username)
    {
        this.email = null;
        this.username = username;
        this.passwordHash = null;
    }

    public String getEmail()
    {
        return email;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public List<MessageThread> getThreadMessages()
    {
        return messageThreadList;
    }

    public void addThreadMessage(MessageThread newMessageThread)
    {
        this.messageThreadList.add(newMessageThread);
    }
}
