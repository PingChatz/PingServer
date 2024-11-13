package chat.ping.main.domain.models;


import jakarta.persistence.*;

import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

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

    @ManyToOne
    @JoinColumn(name = "thread_id", nullable = false)
    private Thread thread;

    /**
     *  This is an abstract method that will be implemented by object that extends this.
     * @return content of the message
     */
    public abstract String getContent();

    // Constructors
    public Message()
    {}

    public Message(User sender, Thread thread)
    {
        this.sender = sender;
        this.timestamp = new Date();
        this.thread = thread;
    }

}
//public abstract class Message {
//
//    String threadID;
//    String senderID;
//    Object content;
//
//    public Message(Object content, Thread thread, User sender) {
//        this.content = content;
//        this.threadID = thread.threadID;
//        this.senderID = sender.getID;
//    }
//
//
//}
