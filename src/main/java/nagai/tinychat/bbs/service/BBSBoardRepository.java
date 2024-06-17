package nagai.tinychat.bbs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nagai.tinychat.bbs.Board;
import nagai.tinychat.util.AppProperties;

@Repository
public class BBSBoardRepository {
    private ArrayList<String> boardData;
    private int lastSaveBoard;
    private int lastLoadBoard;

    private AppProperties properties;

    @Autowired
    public BBSBoardRepository(AppProperties properties) {
        this.properties = properties;
        boardData = new ArrayList<String>();
        loadBoard();
    }

    public void loadBoard() {

    }

    public void saveBoard() {

    }

}
