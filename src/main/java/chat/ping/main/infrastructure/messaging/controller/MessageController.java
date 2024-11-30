package chat.ping.main.infrastructure.messaging.controller;

import chat.ping.main.infrastructure.messaging.presenter.GetMessagesPresenter;
import chat.ping.main.infrastructure.messaging.presenter.SendMessagePresenter;
import chat.ping.main.usecase.messaging.dto.SendMessageRequestModel;
import chat.ping.main.usecase.messaging.getMessages.GetMessagesInputBoundary;
import chat.ping.main.usecase.messaging.sendMessage.SendMessageInputBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController
{
    private final GetMessagesInputBoundary getMessagesInputBoundary;
    private final SendMessageInputBoundary sendMessageInputBoundary;
    private final GetMessagesPresenter getMessagesPresenter;
    private final SendMessagePresenter sendMessagePresenter;

    @Autowired
    public MessageController(GetMessagesInputBoundary getMessagesInputBoundary,
                             SendMessageInputBoundary sendMessageInputBoundary,
                             GetMessagesPresenter getMessagesPresenter,
                             SendMessagePresenter sendMessagePresenter)
    {
        this.getMessagesInputBoundary = getMessagesInputBoundary;
        this.sendMessageInputBoundary = sendMessageInputBoundary;
        this.getMessagesPresenter = getMessagesPresenter;
        this.sendMessagePresenter = sendMessagePresenter;
    }

    @GetMapping("/{threadId}")
    public ResponseEntity<?> getMessages(@PathVariable Long threadId, Authentication authentication)
    {
        String username = authentication.getName();
        getMessagesInputBoundary.getMessages(threadId, username);
        return getMessagesPresenter.getResponseEntity();
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody SendMessageRequestModel requestModel, Authentication authentication)
    {
        String senderUsername = authentication.getName();
        requestModel.setSenderUsername(senderUsername);
        sendMessageInputBoundary.sendMessage(requestModel);
        return sendMessagePresenter.getResponseEntity();
    }
}
