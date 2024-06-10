package nagai.tinychat.bbs;

import java.util.ArrayList;

public interface BBSInterface {
    void saveMessage(String boardId, Message message) throws IllegalArgumentException;

    ArrayList<Message> loadMessage(String boardId) throws IllegalArgumentException;

}
