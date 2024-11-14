package chat.ping.main.domain.models;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public class MessageThread
{
    @Id
    @Getter
    @SequenceGenerator(name = "thread_sequence", sequenceName = "thread_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "thread_sequence")
    @Column(name = "thread_id", updatable = false, nullable = false)
    private Long threadId;

    @Getter
    @Column(name = "thread_name", nullable = false)
    private String threadName;

    @ManyToMany
    @JoinTable(
            name = "thread_participants",
            joinColumns = @JoinColumn(name = "thread_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> participants;

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

    // Constructors
    public MessageThread()
    {}

    public MessageThread(String name, List<User> users)
    {
        // Initialize the values for the messages
        this.threadName = name;
        this.participants = users;
        this.messages = new ArrayList<>();
    }

}
