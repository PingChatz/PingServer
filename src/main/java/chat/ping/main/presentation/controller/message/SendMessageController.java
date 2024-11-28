package chat.ping.main.presentation.controller.message;


import chat.ping.main.application.service.MessageService;
import chat.ping.main.presentation.dto.SendMessageRequest;
import chat.ping.main.presentation.dto.SendMessageResponse;
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
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class SendMessageController
{
    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody SendMessageRequest sendMessageRequest)
    {
        //Get the authentication data
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get teh user email
        String userEmail = authentication.getName();

        SendMessageResponse newMessage = messageService.sendMessage(userEmail, sendMessageRequest);

        // Jsonify the response
        Map<String, SendMessageResponse> response = Map.of("newMessage", newMessage);
        return ResponseEntity.ok(response);
    }

}
