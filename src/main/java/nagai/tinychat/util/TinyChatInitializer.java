package nagai.tinychat.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import nagai.tinychat.bbs.BBSService;
import nagai.tinychat.bbs.Board;

@Component
public class TinyChatInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private final AppProperties appProperties;

    @Autowired
    public TinyChatInitializer(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) throws SecurityException {
        // data directory creation
        String storageLocation = appProperties.getDataDirectory();
        File dataDirectory = new File(storageLocation);
        File bbsDirectory = new File(storageLocation + "bbs/");
        File messageDirectory = new File(bbsDirectory + "message/");
        File bbsListFile = new File(bbsDirectory + "board.txt");

        createIfNotExist(dataDirectory);
        createIfNotExist(bbsDirectory);
        createIfNotExist(bbsListFile);
        createIfNotExist(messageDirectory);

        // set class constant
        try {
            Board.setConst(messageDirectory.getPath());
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
        try {
            BBSService.setConst(bbsListFile.getPath());
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createIfNotExist(File file) throws SecurityException {
        if (!file.exists()) {
            boolean created = file.mkdirs();
            if (created) {
                System.out.println("Directory created: " + file.getPath());
            } else {
                System.err.println("Failed to create directory: " + file.getPath());
            }
        } else {
            System.out.println("Directory already exists: " + file.getPath());
        }
    }
}
