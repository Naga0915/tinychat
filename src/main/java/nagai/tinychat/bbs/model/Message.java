package nagai.tinychat.bbs.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Message {
    private String uuid;
    private LocalDateTime time;
    private String text;
    private String userID;
    private String userName;
    private ArrayList<String> reply;
    private boolean isHidden;

    private Message(String uuid, LocalDateTime time, String text, String userID, String userName,
            ArrayList<String> reply, boolean isHidden) {
        this.uuid = uuid;
        this.time = time;
        this.text = text;
        this.userID = userID;
        this.userName = userName;
        this.reply = reply;
        this.isHidden = isHidden;
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

    public ArrayList<String> getReply() {
        return reply;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public static Message getEmptyMessage() {
        return new Message("", LocalDateTime.MIN, "", "", "", new ArrayList<String>(),
                false);
    }

    public static Message getSystemMessage(String name, String message) {
        return new Message("", LocalDateTime.MIN, message, "system", name, new ArrayList<String>(),
                false);
    }

    // instance creation

    public static Message fromJson(String str)
            throws JsonProcessingException, StreamReadException, DatabindException {
        ObjectMapper om = new ObjectMapper();
        Message m = om.readValue(str, Message.class);
        return m;
    }

    public Message creatMessage(String userID, String userName, String text, ArrayList<String> reply,
            boolean isHidden) {
        return new Message(UUID.randomUUID().toString(), LocalDateTime.now(ZoneId.of("Asia/Tokyo")), text, userID,
                userName, reply, isHidden);
    }

    // methods

    public String toJson() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(this);
    }

    public void hide() {
        this.isHidden = true;
    }
}