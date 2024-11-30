package chat.ping.main.infrastructure.messaging.gateway.messages;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class MessageDataMapper
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(name = "thread_id", nullable = false)
    private Long threadId;

    @Column(name = "sender", nullable = false)
    private String sender;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    // Default constructor for JPA
    public MessageDataMapper() {}

    public MessageDataMapper(Long threadId, String sender, String content, Date timestamp)
    {
        this.threadId = threadId;
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public Long getThreadId() {
        return threadId;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

