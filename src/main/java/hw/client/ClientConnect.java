package hw.client;

import hw.server.Server;

public interface ClientConnect {
    String connect();
    void sendToServer(String message);

}
