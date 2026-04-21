package lectures.Finals.Lecture3.examples.preDatabase;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FormValidationExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("04 - Form Validation Example");
            frame.setSize(480, 250);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(4, 2, 8, 8));

            JTextField nameField = new JTextField();
            JTextField courseField = new JTextField();
            JTextField emailField = new JTextField();
            JButton submitButton = new JButton("Submit");

            submitButton.addActionListener(e -> {
                String name = nameField.getText().trim();
                String course = courseField.getText().trim();
                String email = emailField.getText().trim();

                if (name.isEmpty() || course.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Name and course are required.");
                    return;
                }

                if (!email.isEmpty() && (!email.contains("@") || !email.contains("."))) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email.");
                    return;
                }

                JOptionPane.showMessageDialog(frame,
                        "Input accepted:\nName: " + name + "\nCourse: " + course + "\nEmail: " + email);
            });

            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Course:"));
            panel.add(courseField);
            panel.add(new JLabel("Email (optional):"));
            panel.add(emailField);
            panel.add(new JLabel(""));
            panel.add(submitButton);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
