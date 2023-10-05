package hw.server;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class ServerChatView extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    public static boolean start = false;
    JButton btnStart, btnStop;
    JTextArea serverChatFeild;
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    public ServerChatView(Server server) throws IOException {
        Logger logger = new Logger();
        File icon = new File("src/main/resources/img/icon.jpeg");
        this.setIconImage(ImageIO.read(icon));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("hw.server.ServerChat");
        setResizable(false);
        btnStart = new JButton("Start Server");
        btnStop = new JButton("Stop Server");
        JPanel serverChat = new JPanel(new BorderLayout());
        JPanel buttonServer = new JPanel(new GridLayout(1, 2));
        buttonServer.add(btnStart);
        buttonServer.add(btnStop);
        serverChatFeild = new JTextArea();
        serverChatFeild.setEditable(false);
        serverChat.add(serverChatFeild);
        serverChat.add(buttonServer, BorderLayout.SOUTH);
        setForeground(Color.white);
        add(serverChat);
        setVisible(true);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!server.isRun()) {
                    serverChatFeild.setText("Server is started");
                    setTitle("Server running");
                    server.setRun(true);
                    server.setStatus("server is running");
                } else {
                    serverChatFeild.setText("Server is running");
                }
                logger.serverLog(serverChatFeild.getText());

            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.isRun()) {
                    serverChatFeild.setText("Server is stoped");
                    setTitle("Server stopped");
                    server.setRun(false);
                    server.setStatus("server is not run");
                } else {
                    serverChatFeild.setText("Server is not running now");
                }
                logger.serverLog(serverChatFeild.getText());

            }
        });
    }
}
