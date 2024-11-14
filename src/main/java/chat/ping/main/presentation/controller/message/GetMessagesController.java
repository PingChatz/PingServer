package chat.ping.main.presentation.controller.message;

import chat.ping.main.application.service.MessageService;
import chat.ping.main.presentation.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class GetMessagesController
{
    private final MessageService messageService;

    @GetMapping("/{threadId}")
    public ResponseEntity<?> getMessages(@PathVariable("threadId") Long threadId)
    {
        //Get the authentication data
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get teh user email
        String userEmail = authentication.getName();

        List<MessageDTO> messageList = messageService.getMessages(userEmail, threadId, 100);

        Map<String, List<MessageDTO>> response = Map.of("messages", messageList);

        return ResponseEntity.ok(response);
    }

}
