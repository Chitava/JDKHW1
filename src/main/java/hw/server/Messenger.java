package hw.server;

public class Messenger implements SendMessanger{


    @Override
    public String sendMessage(Server server) {
        return server.getStatus();
    }
}

