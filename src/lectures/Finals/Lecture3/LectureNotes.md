# Lecture 3: GUI + Database Integration (Swing, Events, SQLite)

## Overview

This lecture explains how to build a complete Java desktop application using Swing and SQLite. It focuses on both user interface development and data persistence, so the application remains usable after restart.

You will learn how to:

- design forms and layouts with Swing,
- respond to user actions through events,
- validate input before processing,
- connect to SQLite using JDBC,
- implement CRUD operations safely,
- organize code into clear layers (UI, model, DAO).

---

## Learning Outcomes

After this lecture, you should be able to:

1. Explain the Swing component hierarchy and role of containers.
2. Build responsive form layouts using common layout managers.
3. Implement event handling with listeners and lambdas.
4. Perform input validation and display user-friendly feedback.
5. Connect Java programs to SQLite with JDBC.
6. Use `PreparedStatement` for secure SQL execution.
7. Display and refresh tabular data using `JTable`.
8. Separate presentation and data access logic using DAO.
9. Identify and fix common GUI/database integration bugs.

---

## 1. GUI Fundamentals in Java Swing

## 1.1 What Is a GUI?

A GUI (Graphical User Interface) lets users interact through visual components like buttons, text fields, and tables rather than typed terminal commands.

Console style:

- user types command,
- system prints text result.

GUI style:

- user clicks/chooses/types in controls,
- system reacts visually and immediately.

Complete runnable example:

```java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class GuiIntroExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My First GUI");
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JLabel("Hello, Swing GUI!", JLabel.CENTER));
            frame.setVisible(true);
        });
    }
}
```

---

## 1.2 Swing Component Hierarchy

Important classes:

- `JFrame`: top-level window.
- `JPanel`: container used to group components.
- `JComponent`: base class for many controls (`JButton`, `JTextField`, etc.).

Hierarchy idea:

```text
JFrame
  -> JPanel (form section)
  -> JPanel (button section)
  -> JScrollPane
       -> JTable
```

Use multiple panels to keep layout organized.

Complete runnable example:

```java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class ComponentHierarchyExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hierarchy Demo");
            frame.setSize(560, 320);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel root = new JPanel(new BorderLayout(8, 8));

            JPanel formPanel = new JPanel(new GridLayout(1, 2, 8, 8));
            formPanel.add(new JLabel("Name:"));
            formPanel.add(new javax.swing.JTextField());

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(new JButton("Save"));

            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name"}, 0);
            model.addRow(new Object[]{1, "Ana"});
            JTable table = new JTable(model);

            root.add(formPanel, BorderLayout.NORTH);
            root.add(buttonPanel, BorderLayout.SOUTH);
            root.add(new JScrollPane(table), BorderLayout.CENTER);

            frame.add(root);
            frame.setVisible(true);
        });
    }
}
```

---

## 1.3 Core Swing Components

- `JLabel`: static text.
- `JTextField`: single-line input.
- `JPasswordField`: masked password input.
- `JButton`: action trigger.
- `JComboBox`: drop-down list.
- `JCheckBox`: true/false toggle.
- `JTextArea`: multiline text.
- `JTable`: table/grid display.
- `JOptionPane`: simple dialogs.
- `JScrollPane`: scroll wrapper for large content.

Complete runnable example:

```java
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;

public class CoreComponentsExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Core Components Demo");
            frame.setSize(520, 360);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(7, 2, 8, 8));
            panel.add(new JLabel("Name:"));
            panel.add(new JTextField());
            panel.add(new JLabel("Password:"));
            panel.add(new JPasswordField());
            panel.add(new JLabel("Course:"));
            panel.add(new JComboBox<>(new String[]{"OOP", "DSA", "DBMS"}));
            panel.add(new JLabel("Active:"));
            panel.add(new JCheckBox("Yes"));
            panel.add(new JLabel("Notes:"));
            panel.add(new JScrollPane(new JTextArea(3, 20)));
            panel.add(new JButton("Save"));
            panel.add(new JButton("Clear"));

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
```

---

## 1.4 Layout Managers

Layout managers control where components appear.

### FlowLayout

- Places components left-to-right.
- Best for simple horizontal toolbars.

### GridLayout

- Fixed rows/columns with equal cell sizes.
- Best for aligned forms and button grids.

### BorderLayout

- Five zones: `NORTH`, `SOUTH`, `EAST`, `WEST`, `CENTER`.
- Best for main window structure (header, content, footer).

### Nested Layouts

Professional UIs usually combine layouts:

- `BorderLayout` for the main frame,
- `GridLayout` for input form,
- `FlowLayout` for action buttons.

Complete runnable example:

```java
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LayoutManagersCompleteExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Nested Layout Demo");
            frame.setSize(540, 260);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout(8, 8));

            JPanel formPanel = new JPanel(new GridLayout(2, 2, 8, 8));
            formPanel.add(new JLabel("Name"));
            formPanel.add(new JTextField());
            formPanel.add(new JLabel("Course"));
            formPanel.add(new JTextField());

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.add(new JButton("Save"));
            buttonPanel.add(new JButton("Clear"));

            frame.add(formPanel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}
```

---

## 1.5 Basic Form Example

```java
import javax.swing.*;
import java.awt.*;

public class BasicForm extends JFrame {
    public BasicForm() {
        setTitle("Student Form");
        setSize(420, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 8, 8));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Course:"));
        formPanel.add(new JTextField());
        formPanel.add(new JButton("Save"));
        formPanel.add(new JButton("Clear"));

        add(formPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BasicForm::new);
    }
}
```

---

## 1.6 Look and Feel (Optional but Useful)

Swing can use system-native styling:

```java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LookAndFeelExample {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Look and Feel Example");
            frame.setSize(360, 180);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JLabel("Using system look and feel", JLabel.CENTER));
            frame.setVisible(true);
        });
    }
}
```

This improves visual consistency on Windows/macOS/Linux.

---

## 2. Event-Driven Programming

GUI applications are event-driven. The program waits for user actions and runs listener code when an event happens.

Common event types:

- button click -> `ActionEvent`
- item selection -> `ItemEvent`
- text changes -> `DocumentEvent`
- window close/minimize -> `WindowEvent`

Complete runnable example:

```java
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class EventIntroExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Event Intro Example");
            frame.setSize(420, 220);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            JLabel status = new JLabel("Waiting...");
            JButton submitButton = new JButton("Submit");

            submitButton.addActionListener(e -> status.setText("Submit clicked"));

            frame.add(submitButton);
            frame.add(status);
            frame.setVisible(true);
        });
    }
}
```

---

## 2.1 ActionListener Example

```java
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ActionListenerCompleteExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ActionListener Example");
            frame.setSize(460, 240);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(3, 2, 8, 8));
            JTextField nameField = new JTextField();
            JTextField courseField = new JTextField();
            JButton saveButton = new JButton("Save");

            saveButton.addActionListener(e -> {
                String name = nameField.getText().trim();
                String course = courseField.getText().trim();

                if (name.isEmpty() || course.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Name and course are required.");
                    return;
                }

                JOptionPane.showMessageDialog(frame, "Saved: " + name + " - " + course);
            });

            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Course:"));
            panel.add(courseField);
            panel.add(new JLabel(""));
            panel.add(saveButton);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
```

Lambda syntax is shorter and preferred for single-method interfaces.

---

## 2.2 Other Useful Listeners

### ItemListener (for combo/check)

```java
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ItemListenerExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ItemListener Example");
            frame.setSize(420, 180);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            JLabel label = new JLabel("Selected: OOP");
            JComboBox<String> courseBox = new JComboBox<>(new String[]{"OOP", "DSA", "DBMS"});

            courseBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label.setText("Selected: " + e.getItem());
                }
            });

            frame.add(courseBox);
            frame.add(label);
            frame.setVisible(true);
        });
    }
}
```

### DocumentListener (real-time text validation)

```java
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DocumentListenerExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("DocumentListener Example");
            frame.setSize(460, 180);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            JTextField emailField = new JTextField(20);
            JLabel statusLabel = new JLabel("Enter email");

            emailField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    validateEmail();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    validateEmail();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    validateEmail();
                }

                private void validateEmail() {
                    String value = emailField.getText().trim();
                    boolean valid = value.contains("@") && value.contains(".");
                    statusLabel.setText(valid ? "Valid email" : "Invalid email");
                }
            });

            frame.add(new JLabel("Email:"));
            frame.add(emailField);
            frame.add(statusLabel);
            frame.setVisible(true);
        });
    }
}
```

---

## 2.3 Event Dispatch Thread (EDT)

Swing components must be created and updated on the EDT.

Correct startup:

```java
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new StudentFrame().setVisible(true));
}
```

If heavy operations run on EDT, UI may freeze.

Quick snippet (move heavy work away from direct UI callback):

```java
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class EtdBackgroundTaskExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("EDT Background Task Example");
            frame.setSize(460, 200);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            JLabel statusLabel = new JLabel("Status: idle");
            JButton loadButton = new JButton("Run Long Task");

            loadButton.addActionListener(e -> {
                statusLabel.setText("Status: running...");
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {
                    }
                    SwingUtilities.invokeLater(() -> statusLabel.setText("Status: done"));
                }).start();
            });

            frame.add(loadButton);
            frame.add(statusLabel);
            frame.setVisible(true);
        });
    }
}
```

---

## 3. Input Validation and Error Feedback

Validation should happen before database calls.

Typical checks:

1. Required fields are not blank.
2. String length constraints are met.
3. Email format is acceptable.
4. Numeric input can be parsed.

Example:

```java
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ValidationCompleteExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Validation Example");
            frame.setSize(500, 260);
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

                if (name.isBlank() || course.isBlank()) {
                    JOptionPane.showMessageDialog(frame, "Name and course are required.");
                    return;
                }

                if (!email.isBlank() && (!email.contains("@") || !email.contains("."))) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email.");
                    return;
                }

                JOptionPane.showMessageDialog(frame, "Input is valid.");
            });

            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Course:"));
            panel.add(courseField);
            panel.add(new JLabel("Email:"));
            panel.add(emailField);
            panel.add(new JLabel(""));
            panel.add(submitButton);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
```

Error handling rules:

- Show clear messages for users.
- Log technical details for debugging.
- Do not ignore exceptions silently.

Complete runnable example:

```java
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ErrorHandlingExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Error Handling Example");
            frame.setSize(420, 180);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            JTextField ageField = new JTextField(10);
            JButton parseButton = new JButton("Parse Age");
            JLabel resultLabel = new JLabel("Result: ");

            parseButton.addActionListener(e -> {
                try {
                    int age = Integer.parseInt(ageField.getText().trim());
                    resultLabel.setText("Result: Age = " + age);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Age must be a number.");
                }
            });

            frame.add(new JLabel("Age:"));
            frame.add(ageField);
            frame.add(parseButton);
            frame.add(resultLabel);
            frame.setVisible(true);
        });
    }
}
```

---

## 4. SQLite and JDBC Essentials

## 4.1 Why SQLite?

SQLite is embedded and file-based:

- no separate server setup,
- one `.db` file stores all tables,
- good for desktop apps and classroom projects.

---

## 4.2 JDBC Workflow

1. Open connection.
2. Create `PreparedStatement`.
3. Bind parameters.
4. Execute SQL.
5. Read result (`ResultSet`) if needed.
6. Close resources (use try-with-resources).

---

## 4.3 SQL Schema Example

```sql
CREATE TABLE IF NOT EXISTS students (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    course TEXT NOT NULL,
    email TEXT UNIQUE,
    created_at TEXT DEFAULT CURRENT_TIMESTAMP
);
```

Column notes:

- `id`: unique row key.
- `NOT NULL`: required values.
- `UNIQUE`: duplicate prevention.
- timestamp default: automatic creation time.

---

## 4.4 Connection Example

```java
import java.sql.Connection;
import java.sql.DriverManager;

String url = "jdbc:sqlite:students.db";
try (Connection conn = DriverManager.getConnection(url)) {
    System.out.println("Connected to SQLite");
}
```

---

## 4.5 Safe SQL with PreparedStatement

Unsafe style (avoid):

```java
String sql = "INSERT INTO students(name) VALUES ('" + name + "')";
```

Safe style:

```java
String sql = "INSERT INTO students(name, course, email) VALUES (?, ?, ?)";
try (PreparedStatement ps = conn.prepareStatement(sql)) {
    ps.setString(1, name);
    ps.setString(2, course);
    ps.setString(3, email);
    ps.executeUpdate();
}
```

Why safer:

- avoids SQL injection,
- handles escaping correctly,
- easier to maintain.

---

## 4.6 CRUD Operations (Core SQL)

Create:

```sql
INSERT INTO students(name, course, email) VALUES (?, ?, ?);
```

Read:

```sql
SELECT id, name, course, email, created_at FROM students ORDER BY id DESC;
```

Update:

```sql
UPDATE students SET name = ?, course = ?, email = ? WHERE id = ?;
```

Delete:

```sql
DELETE FROM students WHERE id = ?;
```

---

## 5. UI + DAO Integration Pattern

Architecture:

```text
UI (Swing) -> Validation -> DAO -> SQLite
```

Responsibilities:

- UI:
  - reads input,
  - triggers actions,
  - updates table and dialogs.
- DAO:
  - runs SQL,
  - returns data/results,
  - isolates database details.

This separation improves readability, testing, and maintenance.

---

## 5.1 DAO Example

```java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String URL = "jdbc:sqlite:students.db";

    public void createTableIfNeeded() throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS students (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                course TEXT NOT NULL,
                email TEXT UNIQUE,
                created_at TEXT DEFAULT CURRENT_TIMESTAMP
            )
            """;

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public int insertStudent(String name, String course, String email) throws SQLException {
        String sql = "INSERT INTO students(name, course, email) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, course);
            ps.setString(3, email);
            return ps.executeUpdate();
        }
    }

    public List<String[]> getAllStudents() throws SQLException {
        List<String[]> rows = new ArrayList<>();
        String sql = "SELECT id, name, course, email, created_at FROM students ORDER BY id DESC";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rows.add(new String[] {
                    String.valueOf(rs.getInt("id")),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getString("email"),
                    rs.getString("created_at")
                });
            }
        }

        return rows;
    }

    public int deleteById(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}
```

---

## 5.2 JTable Refresh Pattern

```java
private void refreshTable() {
    try {
        var rows = studentDAO.getAllStudents();
        DefaultTableModel model = (DefaultTableModel) studentsTable.getModel();
        model.setRowCount(0);
        for (String[] row : rows) {
            model.addRow(row);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Failed to load data: " + ex.getMessage());
    }
}
```

Important detail:

- clear existing model rows before repopulating to avoid duplicates.

---

## 6. Important Related Concepts

## 6.1 MVC/MVP Thinking

Even in small apps, think in layers:

- Model: data (`Student` class).
- View: GUI (`StudentFrame`).
- Controller/logic: event actions and service rules.

You do not need a strict framework to apply this idea.

---

## 6.2 Transactions

Use transactions when multiple operations must succeed together.

```java
try (Connection conn = DriverManager.getConnection(URL)) {
    conn.setAutoCommit(false);
    try {
        // multiple statements
        conn.commit();
    } catch (SQLException ex) {
        conn.rollback();
        throw ex;
    } finally {
        conn.setAutoCommit(true);
    }
}
```

---

## 6.3 Indexing for Performance

Indexes speed up frequent search conditions.

```sql
CREATE INDEX IF NOT EXISTS idx_students_email ON students(email);
```

Use indexes on columns frequently used in `WHERE`, `JOIN`, or `ORDER BY`.

---

## 6.4 Pagination and Large Data

When row counts grow, avoid loading everything at once.

```sql
SELECT id, name, course, email, created_at
FROM students
ORDER BY id DESC
LIMIT ? OFFSET ?;
```

This helps memory usage and UI responsiveness.

---

## 6.5 Preventing UI Freezes

Long operations should not block EDT.

Option:

- use `SwingWorker` for background DB work,
- update UI after completion.

Conceptual flow:

1. start worker,
2. execute DB operation in background,
3. update table in `done()`.

---

## 7. Mini Project Specification

Build: `Course Enrollment Manager`.

Required fields:

- Student Name,
- Course,
- Email.

Required actions:

- Add,
- Clear,
- Delete Selected,
- Refresh Table.

Required table columns:

- ID,
- Name,
- Course,
- Email,
- Created At.

Behavior requirements:

1. Name and course must be required.
2. Duplicate email should display a readable message.
3. Add and delete should immediately reflect in `JTable`.
4. App restart should still show saved records.

---

## 8. Common Errors and Practical Fixes

1. `No suitable driver found`

- Cause: SQLite dependency missing.
- Fix: add `sqlite-jdbc` dependency/jar to project.

2. Button clicks do nothing

- Cause: listener not attached.
- Fix: verify `addActionListener(...)` is called once.

3. Insert appears successful but no data stored

- Cause: wrong DB path or swallowed exception.
- Fix: print full exception and confirm `.db` location.

4. Duplicate rows in table

- Cause: not clearing model before refill.
- Fix: call `model.setRowCount(0)` in refresh.

5. Cannot delete selected row

- Cause: no row selected or invalid ID conversion.
- Fix: check selected row index and parse ID carefully.

6. UI freeze during DB operation

- Cause: blocking call on EDT.
- Fix: move heavy operation to background worker.

---

## 9. Suggested Project Structure

```text
src/
  app/
    App.java
  ui/
    StudentFrame.java
  dao/
    StudentDAO.java
  model/
    Student.java
database/
  students.db
```

Optional extension:

```text
src/
  service/
    StudentService.java
```

A service layer is useful when validation/business rules grow.

---

## 10. Practice Tasks

1. Add Update functionality for selected rows.
2. Add search by name/course.
3. Add sorting (A-Z by name).
4. Add CSV export of current table view.
5. Add status label showing last successful operation.
6. Add total record count below the table.

---

## 11. Review Questions

1. What is the difference between `JFrame` and `JPanel`?
2. Why is `PreparedStatement` preferred over string concatenation?
3. What are CRUD operations?
4. Why should SQL logic stay in DAO classes?
5. Why do Swing apps need the Event Dispatch Thread?
6. What causes a GUI to freeze and how can it be prevented?
7. Why is a table model cleared before repopulating?
8. When should transactions be used?

---

## Key Takeaway

A reliable Java desktop app combines:

1. clear GUI structure,
2. correct event handling,
3. strict input validation,
4. safe JDBC access with `PreparedStatement`,
5. clean separation between UI and data access.

This pattern makes applications easier to maintain, debug, and scale.
