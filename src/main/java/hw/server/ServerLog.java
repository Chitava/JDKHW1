package hw.server;

import java.io.File;

public interface ServerLog {
    File logger = new File("src/main/resources/log.txt");
    void serverLog(String text);


}
