package nagai.tinychat.bbs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nagai.tinychat.bbs.Board;

@Repository
public class BBSBoardRepository {
    private ArrayList<Board> boardData;
    private int lastSaveBoard;
    private int lastLoadBoard;

    public BBSBoardRepository() {
        boardData = new ArrayList<Board>();
    }

    public void loadBoard() {

    }

    public void saveBoard() {

    }

    
}
