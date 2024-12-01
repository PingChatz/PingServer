package chat.ping.main.infrastructure.messaging.controller;

import chat.ping.main.infrastructure.messaging.presenter.CreateThreadPresenter;
import chat.ping.main.infrastructure.messaging.presenter.GetThreadsPresenter;
import chat.ping.main.usecase.messaging.createThreads.CreateThreadInputBoundary;
import chat.ping.main.usecase.messaging.dto.CreateThreadRequestModel;
import chat.ping.main.usecase.messaging.getThreads.GetThreadsInputBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/threads")
public class ThreadController
{
    private final CreateThreadInputBoundary createThreadInputBoundary;
    private final GetThreadsInputBoundary getThreadsInputBoundary;
    private final CreateThreadPresenter createThreadPresenter;
    private final GetThreadsPresenter getThreadsPresenter;

    @Autowired
    public ThreadController(CreateThreadInputBoundary createThreadInputBoundary,
                            GetThreadsInputBoundary getThreadsInputBoundary,
                            CreateThreadPresenter createThreadPresenter,
                            GetThreadsPresenter getThreadsPresenter)
    {
        this.createThreadInputBoundary = createThreadInputBoundary;
        this.getThreadsInputBoundary = getThreadsInputBoundary;
        this.createThreadPresenter = createThreadPresenter;
        this.getThreadsPresenter = getThreadsPresenter;
    }

    @PostMapping
    public ResponseEntity<?> createThread(@RequestBody CreateThreadRequestModel requestModel, Authentication authentication)
    {
        String createdBy = authentication.getName();
        requestModel.getParticipants().add(createdBy); // Ensure the creator is a participant
        createThreadInputBoundary.createThread(requestModel);
        return createThreadPresenter.getResponseEntity();
    }

    @GetMapping
    public ResponseEntity<?> getThreads(Authentication authentication)
    {
        String username = authentication.getName();
        getThreadsInputBoundary.getThreads(username);
        return getThreadsPresenter.getResponseEntity();
    }
}
