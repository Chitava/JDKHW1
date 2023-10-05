package hw.server;


import java.io.IOException;

public class Server {
    String status;
    boolean run;
    public Server() throws IOException {
        ServerChatView window = new ServerChatView(this);
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public boolean isRun() {
        return run;
    }
    public void setRun(boolean run) {
        this.run = run;
    }
}
