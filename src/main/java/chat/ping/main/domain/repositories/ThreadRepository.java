package chat.ping.main.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ThreadRepository extends JpaRepository<Thread, Long>
{
    // Find All threads related to a specific User
    List<Thread> findByUserList_Id(Long userId);

    // Finds a thread depending on its thread ID
    Optional<Thread> findByThreadId(String threadId);
}
