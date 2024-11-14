package chat.ping.main.presentation.controller.thread;


import chat.ping.main.application.service.ThreadService;
import chat.ping.main.presentation.dto.CreateMessageThreadRequest;
import chat.ping.main.presentation.dto.CreateMessageThreadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/threads")
@RequiredArgsConstructor
public class CreateThreadController
{
    private final ThreadService threadService;

    @PostMapping
    public ResponseEntity<?> createNewThread(@RequestBody CreateMessageThreadRequest request)
    {
        //Get the authentication data
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get teh user email
        String userEmail = authentication.getName();

        CreateMessageThreadResponse serverResponse = threadService.createMessageThread(userEmail, request);

        Map<String, CreateMessageThreadResponse> response = Map.of("message", serverResponse);

        return ResponseEntity.ok("");
    }


}
