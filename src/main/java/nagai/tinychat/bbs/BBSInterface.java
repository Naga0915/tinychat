package nagai.tinychat.bbs;

import java.util.ArrayList;

public interface BBSInterface {
    // すべての板を読み込む　
    void loadAllBoard();

    // 板のメッセージを読み込む すでに読み込んだメッセージはスキップ
    void loadMessage(Board board);

    // 板のメッセージを保存 既存のメッセージは保存しない
    void saveMessage(Board board);

    ArrayList<Message> getMessages(String boardUuid, int entryNum, int pageNum);

    ArrayList<Board> getBoards(int entryNum, int page);

    void createMessage(String boardUuid, Message message);

    void createBoard(Board board);

    void deleteMessage(String boardUuid, String messageUuid);

    void deleteBoard(String boardUuid);
}
