package lectures.Finals.Lecture3.examples.preDatabase;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ButtonEventExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("03 - Button Event Example");
            frame.setSize(430, 220);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

            JLabel statusLabel = new JLabel("Status: Waiting for click...");
            JButton clickButton = new JButton("Click Me");
            JButton resetButton = new JButton("Reset");

            clickButton.addActionListener(e -> statusLabel.setText("Status: Button clicked!"));
            resetButton.addActionListener(e -> statusLabel.setText("Status: Waiting for click..."));

            frame.add(clickButton);
            frame.add(resetButton);
            frame.add(statusLabel);

            frame.setVisible(true);
        });
    }
}
