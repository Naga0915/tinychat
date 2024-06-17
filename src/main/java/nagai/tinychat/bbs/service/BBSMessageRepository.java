package nagai.tinychat.bbs.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import nagai.tinychat.bbs.Message;

@Repository
public class BBSMessageRepository {
        public static ArrayList<Message> loadMessagesFromFile(String uuid)
            throws SecurityException, FileNotFoundException, UnsupportedOperationException {
        if (MESSAGE_DIR == null)
            throw new UnsupportedOperationException("tried to use MESSAGE_DIR before initializing");

        File messageDir = new File(MESSAGE_DIR + uuid + ".txt");
        ArrayList<Message> messages = new ArrayList<Message>();

        if (!messageDir.exists()) {
            throw new FileNotFoundException("specified message file does not exists.");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(messageDir))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Message m = Message.fromJson(line);
                    if (m.getIsHidden()) {
                        messages.add(Message.getEmptyMessage());
                    } else {
                        messages.add(m);
                    }
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                    messages.add(Message.getEmptyMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return messages;
    }

}
