package nagai.tinychat.bbs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Message {
    private String uuid;
    private LocalDateTime time;
    private String text;
    private String userID;
    private String userName;
    private ArrayList<String> reply;

    private Message(String uuid, LocalDateTime time, String text, String userID, String userName,
            ArrayList<String> reply) {
        this.uuid = uuid;
        this.time = time;
        this.text = text;
        this.userID = userID;
        this.userName = userName;
        this.reply = reply;
    }

    public String getUuid() {
        return uuid;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getText() {
        return text;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    // instance creation

    public ArrayList<String> getReply() {
        return reply;
    }

    // TODO:制御文字の除去
    public Message creatMessage(String userID, String userName, String text, ArrayList<String> reply) {
        return new Message(UUID.randomUUID().toString(), LocalDateTime.now(), text, userID, userName, reply);
    }

    // methods

    private static String escapeCsv(String input) {
        input = input.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");
        if (input.contains(",") || input.contains("\"") || input.contains("\n")) {
            input = input.replace("\"", "\"\"");
        }
        return input;
    }

    public String toString() {
        StringBuilder textBuilder = new StringBuilder();

    }

    public Message fromString(String str) {

    }
}
