package chat.ping.main.domain.models;
import chat.ping.main.domain.models.User;

import java.util.ArrayList;
import java.util.List;

public class Thread {

    String threadID;
    String name;
    List<User> userList;

    public Thread(String name) {
        this.name = name;
        this.userList = new ArrayList<>();
        // TODO: add a randomized threadID, the unique identifier of this Thread
    }

    public Thread(String name, List<User> userList) {
        this.name = name;
        this.userList = userList;
        // TODO: add a randomized threadID, the unique identifier of this Thread
    }

    public String getName() {
        return name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public String getThreadID() {
        return threadID;
    }
}
