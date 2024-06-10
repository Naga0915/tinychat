package nagai.tinychat.bbs;

import java.util.ArrayList;
import java.util.Dictionary;

import org.springframework.stereotype.Service;

@Service
public class BBSService implements BBSInterface {
    private Dictionary<String, ArrayList<Board>> boardData;
}
