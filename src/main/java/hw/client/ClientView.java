package hw.client;

import hw.server.Server;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ClientView extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int FIELD_WIDTH = 200;
    private static final int FIELD_HIGHT = 30;
    JButton btnLogin, btnSend;
    JTextField fieldIp, fieldPort, fieldLoggin, fieldMessage;
    JPasswordField fieldPasword;
    JTextArea clientChatFeild;
    JPanel sendMessage;
    public ClientView(Server serv, Client client) throws IOException {
        Connect connect = new Connect(serv);
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
        clientChatFeild.setEditable(false);
        clientChatFeild.setWrapStyleWord(true);
        clientChatFeild.setLineWrap(true);
        JPanel pnlLoggin = createLoginPanel();
        add(pnlLoggin, BorderLayout.PAGE_START);
        add(clientChatFeild);
        sendMessage = createPanelSendMessage();
        add(sendMessage, BorderLayout.SOUTH);
        sendMessage.setVisible(false);
        setVisible(true);
        btnLogin.addActionListener(new ActionListener() {
                                       @Override
                                       public void actionPerformed(ActionEvent e) {
                                           client.setName(fieldLoggin.getText());
                                           if (serv.isRun()) {
                                               pnlLoggin.setVisible(false);
                                               sendMessage.setVisible(true);
                                               clientChatFeild.setText((client.getName() + " вошел в систему"));
                                               serv.addClient(client);
                                           } else {
                                               clientChatFeild.setText(serv.getStatus());

                                           }
                                       }
                                   }
        );
        btnSend.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          String message = client.getName() + " пишет: " + fieldMessage.getText();
                                          clientChatFeild.setText(message);
                                          fieldMessage.setText("");
                                          if (serv.isRun()){
                                              connect.sendToServer(message);
                                          }else{
                                              clientChatFeild.setText("server is stopped");
                                          }
                                      }
                                  }
        );
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 3));
        fieldIp.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HIGHT));
        panel.add(fieldIp);
        fieldPort.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HIGHT));
        panel.add(fieldPort);
        JLabel nothing = new JLabel("");
        panel.add(nothing);
        panel.add(fieldLoggin, BorderLayout.LINE_START);
        fieldLoggin.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HIGHT));
        panel.add(fieldPasword, BorderLayout.CENTER);
        fieldPasword.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HIGHT));
        panel.add(btnLogin, BorderLayout.LINE_END);
        btnLogin.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HIGHT));
        return panel;
    }

    private JPanel createPanelSendMessage() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(fieldMessage);
        btnSend.setPreferredSize(new Dimension(200, 30));
        panel.add(fieldMessage);
        panel.add(btnSend, BorderLayout.LINE_END);
        return panel;
    }
}