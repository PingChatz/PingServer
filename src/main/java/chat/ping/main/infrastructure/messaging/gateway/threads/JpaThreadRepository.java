package chat.ping.main.infrastructure.messaging.gateway.threads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaThreadRepository extends JpaRepository<ThreadDataMapper, Long>
{
    List<ThreadDataMapper> findByParticipantsContaining(String username);
}
