package chat.ping.main.domain.repositories;

import chat.ping.main.domain.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long>
{
    // Finds all messages in a thread sorted in chronological order
    List<Message> findByThreadOrderByTimestampAsc(Thread thread);
}
