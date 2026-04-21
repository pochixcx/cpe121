package lectures.Finals.Lecture3.examples.preDatabase;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class EnrollmentManagerNoDB {
    private final JTextField nameField = new JTextField();
    private final JTextField courseField = new JTextField();
    private final JTextField emailField = new JTextField();
    private final DefaultTableModel model = new DefaultTableModel(
            new String[] { "ID", "Name", "Course", "Email" }, 0);

    private int nextId = 1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EnrollmentManagerNoDB().createAndShowUI());
    }

    private void createAndShowUI() {
        JFrame frame = new JFrame("06 - Enrollment Manager (No DB)");
        frame.setSize(760, 420);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 8, 8));
        formPanel.add(new JLabel("Student Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Course:"));
        formPanel.add(courseField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        JButton addButton = new JButton("Add");
        JButton clearButton = new JButton("Clear");
        formPanel.add(addButton);
        formPanel.add(clearButton);

        JTable table = new JTable(model);

        JButton deleteButton = new JButton("Delete Selected");

        addButton.addActionListener(e -> addStudent(frame));
        clearButton.addActionListener(e -> clearFields());
        deleteButton.addActionListener(e -> deleteSelectedRow(table, frame));

        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.add(deleteButton);
        frame.add(southPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addStudent(JFrame frame) {
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

        model.addRow(new Object[] { nextId++, name, course, email });
        clearFields();
    }

    private void deleteSelectedRow(JTable table, JFrame frame) {
        int rowIndex = table.getSelectedRow();
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(frame, "Select a row first.");
            return;
        }
        model.removeRow(rowIndex);
    }

    private void clearFields() {
        nameField.setText("");
        courseField.setText("");
        emailField.setText("");
    }
}
