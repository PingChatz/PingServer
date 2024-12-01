package chat.ping.main.usecase.messaging.createThreads;

import chat.ping.main.usecase.messaging.dto.CreateThreadRequestModel;

public interface CreateThreadInputBoundary
{
    void createThread(CreateThreadRequestModel requestModel);
}
