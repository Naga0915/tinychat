package nagai.tinychat.bbs.repository;

import java.util.ArrayList;

import nagai.tinychat.bbs.model.Message;

public interface MessageRepository {
    /**
     * get messages of board.
     * 
     * @param boardId board uuid.
     * @param from    get messages from this index.
     * @param num     number of messages. 0 to maximum number. maximum number can be
     *                set in application.properties
     * @return ArrayList of message.
     */
    ArrayList<Message> getMessage(String boardId, int from, int num);

    /**
     * create and post message to board.
     * 
     * @param boardId  board uuid.
     * @param userID   poster user id.
     * @param userName poster user name.
     * @param text     text.
     */
    void postMessage(String boardId, String userID, String userName, String text);

    /**
     * hide message. admin only.
     * 
     * @param boardId   board uuid.
     * @param messageId message uuid
     */
    void hideMessage(String boardId, String messageId);
}
