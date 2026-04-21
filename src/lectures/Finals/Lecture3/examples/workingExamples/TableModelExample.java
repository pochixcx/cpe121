package lectures.Finals.Lecture3.examples.workingExamples;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TableModelExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("05 - JTable + DefaultTableModel Example");
            frame.setSize(620, 320);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout(8, 8));

            String[] columns = { "ID", "Name", "Course" };
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            JTable table = new JTable(model);

            JButton loadSampleButton = new JButton("Load Sample Data");
            loadSampleButton.addActionListener(e -> {
                model.setRowCount(0);
                model.addRow(new Object[] { 1, "Ana", "OOP" });
                model.addRow(new Object[] { 2, "Ben", "Data Structures" });
                model.addRow(new Object[] { 3, "Cris", "Databases" });
            });

            JButton clearButton = new JButton("Clear Table");
            clearButton.addActionListener(e -> model.setRowCount(0));

            frame.add(new JScrollPane(table), BorderLayout.CENTER);

            javax.swing.JPanel southPanel = new javax.swing.JPanel();
            southPanel.add(loadSampleButton);
            southPanel.add(clearButton);
            frame.add(southPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
