package lectures.Finals.Lecture3.examples.preDatabase;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class BasicWindowExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("01 - Basic Window Example");
            frame.setSize(420, 220);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(new JLabel("Welcome to Java Swing!", JLabel.CENTER));
            frame.setVisible(true);
        });
    }
}
