package nagai.tinychat.bbs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nagai.tinychat.util.TinyChatSecurity;
import nagai.tinychat.util.TinyUtil;

public class Board {
    private String uuid;
    private String title;
    private String userId;
    private ArrayList<String> tags;
    private String passwordHash;
    private boolean isHidden;

    private Board() {
    }

    private Board(String uuid, String title, String userId, ArrayList<String> tags, String passwordHash,
            boolean isHidden) {
        this.uuid = uuid;
        this.title = title;
        this.userId = userId;
        this.tags = tags;
        this.passwordHash = passwordHash;
        this.isHidden = isHidden;
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

    public boolean isHidden() {
        return isHidden;
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

    // instance creation

    public static Board createNewBoard(String title, String userId, ArrayList<String> tags, boolean isHidden) {
        Board b = new Board(UUID.randomUUID().toString(), TinyUtil.removeAllCtlChar(title), userId, tags, userId,
                isHidden);
        return b;
    }

    public static Board fromJson(String str)
            throws JsonProcessingException, StreamReadException, DatabindException, FileNotFoundException {
        ObjectMapper om = new ObjectMapper();
        Board b = om.readValue(str, Board.class);
        return b;
    }
}