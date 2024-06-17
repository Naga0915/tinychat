package nagai.tinychat.bbs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nagai.tinychat.util.TinyChatSecurity;
import nagai.tinychat.util.TinyUtil;

public class Board {
    // TODO:板の追加
    private String uuid;
    private String title;
    private String userId;
    private ArrayList<String> tags;
    private String passwordHash;
    private boolean isHidden;

    @JsonIgnore
    private ArrayList<Message> messages;
    @JsonIgnore
    private boolean isChanged;
    @JsonIgnore
    private int lastChange;

    private Board() {
    }

    private Board(String uuid, String title, String userId, ArrayList<String> tags, String passwordHash,
            ArrayList<Message> messages, boolean isHidden) {
        this.uuid = uuid;
        this.title = title;
        this.userId = userId;
        this.tags = tags;
        this.passwordHash = passwordHash;
        this.messages = messages;
        this.isHidden = isHidden;

        this.isChanged = false;
    }

    // getter

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getUserId() {
        return userId;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public boolean isHidden() {
        return isHidden;
    }

    // setter

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    // methods

    public String toJson() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(this);
    }

    public boolean authenticate(String password) {
        if (TinyChatSecurity.passwordCheck(password, passwordHash)) {
            return true;
        }
        return false;
    }

    public void addMessage(Message m) {
        this.messages.add(m);
    }

    public void deleteMessage(String uuid) {
        for (Message m : messages) {
            if (m.getUuid() == uuid) {
                m.hide();
                break;
            }
        }
    }

    // instance creation
    
    public static Board createBoard(String title, String userId, ArrayList<String> tags, boolean isHidden) {
        Board b = new Board(UUID.randomUUID().toString(), TinyUtil.removeAllCtlChar(title), userId, tags, userId,
                new ArrayList<Message>(), isHidden);
        return b;
    }

    public static Board fromJson(String str)
            throws JsonProcessingException, StreamReadException, DatabindException, FileNotFoundException {
        ObjectMapper om = new ObjectMapper();
        Board b = om.readValue(str, Board.class);
        return b;
    }
}