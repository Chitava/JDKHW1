import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Client extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int FIELD_WIDTH = 200;
    private static final int FIELD_HIGHT = 30;
    JButton btnLogin, btnSend;
    JTextField fieldIp, fieldPort, fieldLoggin, fieldMessage;
    JPasswordField fieldPasword;
    JTextArea clientChatFeild;


    Client() throws IOException {

        File icon = new File("src/main/resources/img/icon.jpeg");
        this.setIconImage(ImageIO.read(icon));
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("ClientChat");
        setResizable(false);
        btnLogin = new JButton("Вход");
        btnSend = new JButton("Отправить");
        fieldIp = new JTextField();
        fieldPort = new JTextField();
        fieldLoggin = new JTextField();
        fieldPasword = new JPasswordField();
        fieldMessage = new JTextField();
        clientChatFeild = new JTextArea();

        JPanel pnlLoggin = new JPanel(new GridLayout(2,3));
        JPanel pnlMessage = new JPanel(new BorderLayout());
        fieldIp.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HIGHT));
        pnlLoggin.add(fieldIp);
        fieldPort.setPreferredSize(new Dimension(FIELD_WIDTH,FIELD_HIGHT));
        pnlLoggin.add(fieldPort);
        JLabel nothing = new JLabel("");
        pnlLoggin.add(nothing);

        pnlLoggin.add(fieldLoggin, BorderLayout.LINE_START);
        fieldLoggin.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HIGHT));
        pnlLoggin.add(fieldPasword, BorderLayout.CENTER);
        fieldPasword.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HIGHT));
        pnlLoggin.add(btnLogin, BorderLayout.LINE_END);
        btnLogin.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HIGHT));
        pnlMessage.add(fieldMessage);
        add(pnlLoggin, BorderLayout.PAGE_START);
        clientChatFeild.setEditable(false);
        add(clientChatFeild);

        btnSend.setPreferredSize(new Dimension(200, 30));
        pnlMessage.add(fieldMessage);
        pnlMessage.add(btnSend, BorderLayout.LINE_END);

        add(pnlMessage, BorderLayout.SOUTH);
        setVisible(true);

    }
}