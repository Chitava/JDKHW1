package hw.client;

import hw.server.Server;

import javax.swing.*;
import java.io.IOException;

public class Client {
    private String name;
    private String message;
    private String status;
    private Server server;
    private ClientView window;

    public Client(Server server) throws IOException {
        this.window = new ClientView(server, this);
        this.server = server;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status.toString();
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public JTextArea getWindow() {
        return window.clientChatFeild;
    }
}
