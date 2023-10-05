package hw.server;
import hw.client.Warning;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import static hw.server.ServerChatView.dateFormatter;


public class Logger implements ServerLog {
    @Override
    public void serverLog(String message) {
        try (FileOutputStream writerLog = new FileOutputStream(logger, true)) {
            String textLog = String.valueOf(" " + message + "\n");
            LocalDateTime now = LocalDateTime.now();
            byte[] buffer = dateFormatter.format(now).getBytes();
            writerLog.write(buffer, 0, buffer.length);
            buffer = textLog.getBytes();
            writerLog.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            new Warning("Файл не найден");
        }
    }
}
