package chat.ping.main.domain.repositories;

import chat.ping.main.domain.models.MessageThread;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageThreadRepository extends JpaRepository<MessageThread, Long>
{

}
