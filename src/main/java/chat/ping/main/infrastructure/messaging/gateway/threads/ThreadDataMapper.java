package chat.ping.main.infrastructure.messaging.gateway.threads;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "threads")
public class ThreadDataMapper
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thread_id")
    private Long id;

    @Column(name = "thread_name", nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "thread_participants", joinColumns = @JoinColumn(name = "thread_id"))
    @Column(name = "username")
    private List<String> participants = new ArrayList<>();

    // Default constructor for JPA
    public ThreadDataMapper()
    {
    }

    public ThreadDataMapper(String name, List<String> participants)
    {
        this.name = name;
        this.participants = participants;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<String> getParticipants()
    {
        return participants;
    }

    public void setParticipants(List<String> participants)
    {
        this.participants = participants;
    }
}
