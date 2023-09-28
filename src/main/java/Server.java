import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    boolean start;
    private File logger = new File("src/main/resources/log.txt");
    JButton btnStart, btnStop;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    Server() throws IOException {

        File icon = new File("src/main/resources/img/icon.jpeg");
        this.setIconImage(ImageIO.read(icon));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("ServerChat");
        setResizable(false);
        btnStart = new JButton("Start Server");
        btnStop = new JButton("Stop Server");
        JPanel serverChat = new JPanel(new BorderLayout());
        JPanel buttonServer = new JPanel(new GridLayout(1, 2));
        buttonServer.add(btnStart);
        buttonServer.add(btnStop);
        JTextArea serverChatFeild = new JTextArea();
        serverChatFeild.setEditable(false);
        serverChat.add(serverChatFeild);
        serverChat.add(buttonServer, BorderLayout.SOUTH);
        setForeground(Color.white);
        add(serverChat);
        setVisible(true);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!start) {
                    serverChatFeild.setText("StartServer");
                    start = true;
                } else {
                    serverChatFeild.setText("Server is running");
                }
                writeLog(serverChatFeild);
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (start) {
                    serverChatFeild.setText("Server is Stoped");
                    start = false;
                } else {
                    serverChatFeild.setText("Server is not running now");
                }
                writeLog(serverChatFeild);
            }
        });
    }

    private void writeLog(JTextArea area) {
        try (FileOutputStream writerLog = new FileOutputStream(logger, true)) {
            String textLog = String.valueOf(" " + area.getText() + "\n");
            LocalDateTime now = LocalDateTime.now();
            byte[] buffer = dateFormatter.format(now).getBytes();
            writerLog.write(buffer, 0, buffer.length);
            buffer = textLog.getBytes();
            writerLog.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            new Warning("Файл не найден");
        }
    }
}