package chat.ping.main.use_case.logout;

public class LogoutInteractor implements LogoutInputBoundary {
    private final LogoutOutputBoundary outputBoundary;

    public LogoutInteractor(LogoutOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void logout(LogoutInputData inputData) {
        // Sample business logic for logout
        boolean success = logoutUser(inputData.getUserId());
        String message = success ? "Logout successful" : "Logout failed";

        LogoutOutputData outputData = new LogoutOutputData(success, message);
        outputBoundary.presentLogoutStatus(outputData);
    }

    private boolean logoutUser(String userId) {
        // Here you would add logic to end the user's session,
        // clear tokens, etc.
        return true;  // Assume logout is successful for this example
    }
}

