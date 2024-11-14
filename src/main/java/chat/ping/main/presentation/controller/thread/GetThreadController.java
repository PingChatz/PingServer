package chat.ping.main.presentation.controller.thread;

import chat.ping.main.application.service.ThreadService;
import chat.ping.main.presentation.dto.MessageThreadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/threads")
@RequiredArgsConstructor
public class GetThreadController
{
    private final ThreadService threadService;

    @GetMapping
    public ResponseEntity<?> getMessageThread()
    {
        //Get the authentication data
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get teh user email
        String userEmail = authentication.getName();

        // Collect the Thread List
        List<MessageThreadResponse> threads = threadService.getMessageThreads(userEmail);

        // Convert it to a map
        Map<String, List<MessageThreadResponse>> response = Map.of("message_threads", threads);
        // Return List
        return ResponseEntity.ok(response);
    }
}
