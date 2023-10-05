import hw.client.Client;
import hw.client.ClientView;
import hw.server.Server;
import hw.server.ServerChatView;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        Client client = new Client(server);

    }
}