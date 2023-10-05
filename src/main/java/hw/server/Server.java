package hw.server;


import hw.client.Client;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Server {
    ArrayList<Client> clients = new ArrayList<>();
    String status = "server is stopped";
    boolean run;
    ServerChatView window;
    public Server() throws IOException {
        window = new ServerChatView(this);
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
    public void getMessage(String message){
        Logger logger = new Logger();
        window.setServerChatFeild(message);
        logger.serverLog(message);
    }
    public void addClient(Client client) {
        this.clients.add(client);
    }
}
