package hw.client;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Warning extends JFrame {

    public Warning(String message) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, message,
                "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}



