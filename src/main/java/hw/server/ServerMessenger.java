package hw.server;

import hw.client.Client;

import javax.swing.*;
import java.util.ArrayList;

public class ServerMessenger implements SendMessanger{

    @Override
    public String sendMessage(Server server) {
        return server.getStatus();
    }

    @Override
    public void sendToClient(String messenger, ArrayList<Client> clients) {
        for (Client client: clients
             ) {
            JTextArea window = client.getWindow();
            window.setText(messenger);
        }

    }

}

