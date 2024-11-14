package chat.ping.main.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class TextMessage extends Message
{
    @Column(nullable = false)
    private String content;

    public TextMessage()
    {}

    public TextMessage(String content, User sender, Thread thread)
    {
        super(sender, thread);
        this.content = content;
    }

    @Override
    public String getContent()
    {
        return content;
    }

}

