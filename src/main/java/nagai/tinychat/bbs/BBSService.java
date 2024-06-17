package nagai.tinychat.bbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nagai.tinychat.bbs.service.BBSBoardRepository;
import nagai.tinychat.bbs.service.BBSMessageRepository;

@Service
public class BBSService implements BBSInterface {
    private HashMap<String, Board> boardData;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private final BBSBoardRepository boardService;
    private final BBSMessageRepository messageService;

    private int lastBoardIndex;

    private static String BOARD_TXT_DIR = null;
    private static boolean _STATIC_SET = false;

    @Autowired
    public BBSService(BBSBoardRepository board, BBSMessageRepository message) {
        boardData = new HashMap<String, Board>();
        boardService = board;
        messageService = message;
    }

    public static void setConst(String dir) throws UnsupportedOperationException {
        if (_STATIC_SET)
            throw new UnsupportedOperationException("static value are already set");
        _STATIC_SET = true;
        BOARD_TXT_DIR = dir;
    }

    public String getBoardTxtDir() {
        return BOARD_TXT_DIR;
    }

    @Override
    public void createBoard(Board board) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createMessage(String boardUuid, Message message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteBoard(String boardUuid) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteMessage(String boardUuid, String messageUuid) {
        // TODO Auto-generated method stub

    }

    @Override
    public ArrayList<Board> getBoards(int entryNum, int page) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Message> getMessages(String boardUuid, int entryNum, int pageNum) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void loadAllBoard() {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadMessage(Board board) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveMessage(Board board) {
        // TODO Auto-generated method stub

    }
}
