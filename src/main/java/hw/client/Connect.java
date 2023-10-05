package hw.client;

import hw.server.Server;

public class Connect implements ClientConnect {
    private Server server;

    Connect(Server server) {
        this.server = server;

    }
    @Override
    public String connect() {
       return this.server.getStatus();
    }

    @Override
    public void sendToServer(String message) {
        this.server.getMessage(message);
    }




}
