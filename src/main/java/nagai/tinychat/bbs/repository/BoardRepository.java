package nagai.tinychat.bbs.repository;

import java.util.ArrayList;

import nagai.tinychat.bbs.model.Board;
import nagai.tinychat.bbs.model.Filter;

public interface BoardRepository {
    /**
     * create new board.
     * 
     * @param title    title of board.
     * @param userId   id of user who created board.
     * @param tags     tags of board.
     * @param password password of board. empty to public board.
     */
    void createBoard(String title, String userId, ArrayList<String> tags, String password);

    /**
     * find board with filter.
     * 
     * @param filter filter.
     * @param page   page num.
     * @return
     */
    ArrayList<Board> findBoard(Filter filter, int page);

    /**
     * hide board. admin only.
     * @param uuid board 
     */
    void hideBoard(String uuid);
}
