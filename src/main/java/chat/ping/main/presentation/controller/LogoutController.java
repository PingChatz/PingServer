package chat.ping.main.presentation.controller;

import chat.ping.main.use_case.logout.LogoutInputBoundary;
import chat.ping.main.use_case.logout.LogoutInputData;

public class LogoutController {
    private final LogoutInputBoundary logoutInteractor;

    public LogoutController(LogoutInputBoundary logoutInteractor) {
        this.logoutInteractor = logoutInteractor;
    }

    public void handleLogout(String userId) {
        LogoutInputData inputData = new LogoutInputData(userId);
        logoutInteractor.logout(inputData);
    }
}
