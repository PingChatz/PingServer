package chat.ping.main.use_case.logout;

public class LogoutInputData {
    private final String userId;

    public LogoutInputData(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}

