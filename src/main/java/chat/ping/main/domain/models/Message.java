package chat.ping.main.domain.models;


import jakarta.persistence.*;

import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

/***
 * Abstract class for messages in the system.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Message
{

    @Id
    @SequenceGenerator(name = "message_sequence", sequenceName = "message_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "message_sequence")
    private Long messageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @Column(nullable = false)
    private Date timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thread_id", nullable = false)
    private MessageThread thread;

    /**
     *  This is an abstract method that will be implemented by object that extends this.
     * @return content of the message
     */
    public abstract String getContent();

    // Constructors
    public Message()
    {}

    public Message(User sender, MessageThread thread)
    {
        this.sender = sender;
        this.timestamp = new Date();
        this.thread = thread;
    }

}
