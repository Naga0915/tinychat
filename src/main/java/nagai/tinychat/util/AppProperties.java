package nagai.tinychat.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("tinychat")
public class AppProperties {
    private String dataDirectory = "data/";

    public String getDataDirectory() {
        return dataDirectory;
    }
}
    