package chat.ping.main.infrastructure.messaging.gateway.messages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaMessageRepository extends JpaRepository<MessageDataMapper, Long>
{
    List<MessageDataMapper> findByThreadId(Long threadId);
}
