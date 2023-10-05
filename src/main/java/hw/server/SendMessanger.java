package hw.server;

import hw.client.Client;

import java.util.ArrayList;

public interface SendMessanger {

    String sendMessage(Server server);
    void sendToClient(String messenger, ArrayList<Client> clients);
}
