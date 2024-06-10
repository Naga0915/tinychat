package nagai.tinychat.bbs;

import java.util.ArrayList;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nagai.tinychat.util.TinyUtil;

public class Board {
    // TODO:板の追加
    private String uuid;
    private String title;
    private String userId;
    private ArrayList<String> tags;
    private String passwordHash;

    @JsonIgnore
    private ArrayList<Message> messages;

    private boolean isChanged;

    // const
    private static boolean _IS_CONST_SET = false;
    private static String MESSAGE_DIR;

    private Board() {
    }

    private Board(String uuid, String title, String userId, ArrayList<String> tags, String passwordHash,
            ArrayList<Message> messages) {
        this.uuid = uuid;
        this.title = title;
        this.userId = userId;
        this.tags = tags;
        this.passwordHash = passwordHash;
        this.messages = messages;

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

    public static String getMessageDir() {
        return MESSAGE_DIR;
    }

    // setter

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public static void setConst(String messageDir) throws UnsupportedOperationException {
        if (_IS_CONST_SET)
            throw new UnsupportedOperationException("static values are already set.");
        _IS_CONST_SET = true;
        MESSAGE_DIR = messageDir;
    }

    // methods

    public String toJson() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(this);
    }

    // instance creation

    public static Board createBoard(String title, String userId, ArrayList<String> tags) {
        Board b = new Board(UUID.randomUUID().toString(), TinyUtil.removeAllCtlChar(title), userId, tags, userId,
                new ArrayList<Message>());
        return b;
    }

    public static Board fromJson(String str, ArrayList<Message> messages)
            throws JsonProcessingException, StreamReadException, DatabindException {
        ObjectMapper om = new ObjectMapper();
        Board b = om.readValue(str, Board.class);
        b.setMessages(messages);
        return b;
    }

    // file system

    public static ArrayList<Message> loadMessagesFromFile() {

    }
}