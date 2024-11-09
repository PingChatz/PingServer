package chat.ping.main.domain.models;

public abstract class Message {

    String threadID;
    String senderID;
    Object content;

    public Message() {
    }
}
