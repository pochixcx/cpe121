package lectures.Finals.Lecture3.examples.workingExamples;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LayoutManagersExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("02 - Layout Managers Example");
            frame.setSize(560, 320);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout(8, 8));

            JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            northPanel.add(new JButton("Flow A"));
            northPanel.add(new JButton("Flow B"));
            northPanel.add(new JButton("Flow C"));

            JPanel centerPanel = new JPanel(new GridLayout(2, 2, 8, 8));
            centerPanel.add(new JButton("Grid 1"));
            centerPanel.add(new JButton("Grid 2"));
            centerPanel.add(new JButton("Grid 3"));
            centerPanel.add(new JButton("Grid 4"));

            frame.add(northPanel, BorderLayout.NORTH);
            frame.add(centerPanel, BorderLayout.CENTER);
            frame.add(new JButton("South Action"), BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
