package nagai.tinychat.bbs.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nagai.tinychat.bbs.model.Board;
import nagai.tinychat.util.AppProperties;

@Repository
public class BBSBoardRepositoryImpl implements BoardRepository {
    private ArrayList<String> boardData;
    private int lastSaveBoard;
    private int lastLoadBoard;

    private AppProperties properties;

    @Autowired
    public BBSBoardRepositoryImpl(AppProperties properties) {
        this.properties = properties;
        boardData = new ArrayList<String>();
        loadBoard();
    }

    public void loadBoard() {

    }

    public void saveBoard() {

    }

}
