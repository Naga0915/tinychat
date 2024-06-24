package nagai.tinychat.bbs.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Filter {
    private String title;
    private ArrayList<String> tags;
    // TODO:hot値の計算方法を考える
    private int hotterThan;

    public Filter(String title, ArrayList<String> tags, int hotterThan) {
        this.title = title;
        this.tags = tags;
        this.hotterThan = hotterThan;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getTage() {
        return tags;
    }

    public int getHotterThan() {
        return hotterThan;
    }

    // instance creation
    // find by regex
    /**
     * for searching board.
     * 
     * @param title      find board with regex. * to disable.
     * @param tags       find board that matches tags. null to disable.
     * @param hotterThan hot value. -1 to disable.
     * @return new filter
     */
    public static Filter createFilter(String title, ArrayList<String> tags, int hotterThan)
            throws IllegalArgumentException {
        if (hotterThan <= -1)
            throw new IllegalArgumentException("hotterThan must be bigger than -1");
        if (title.isEmpty())
            throw new IllegalArgumentException("title regex can't be empty.");
        return new Filter(title, tags, hotterThan);
    }
}
