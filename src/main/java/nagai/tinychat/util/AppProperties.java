package nagai.tinychat.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("tinychat")
public class AppProperties {
    private String dataDirectory = "data/";
    private int messageGetMaxNum = 100;

    public String getDataDirectory() {
        return dataDirectory;
    }

    public int getMessageGetMaxNum() {
        return messageGetMaxNum;
    }
}
