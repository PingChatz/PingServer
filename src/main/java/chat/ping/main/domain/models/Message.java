package chat.ping.main.domain.models;

public abstract class Message {

    String threadID;
    String senderID;
    Object content;

    public Message(Object content, Thread thread, User sender) {
        this.content = content;
        this.threadID = thread.threadID;
        this.senderID = sender.userID;
    }


}
