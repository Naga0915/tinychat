package nagai.tinychat.bbs.service;

import java.util.ArrayList;

import nagai.tinychat.bbs.model.Board;
import nagai.tinychat.bbs.model.Message;

public interface BBSService {
    ArrayList<Message> getMessages(String boardUuid, int entryNum, int pageNum);

    ArrayList<Board> getBoards(int entryNum, int page);

    void createMessage(String boardUuid, Message message);

    void createBoard(Board board);

    // for admin use
    void deleteMessage(String boardUuid, String messageUuid);

    // for admin use
    void deleteBoard(String boardUuid);
}