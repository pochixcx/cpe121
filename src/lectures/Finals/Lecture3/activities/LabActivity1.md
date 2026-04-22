# Lab Activity: Pre-Database GUI Practice

## Title

Course Enrollment Manager (Without Database)

## Duration

60-75 minutes

## Objective

Build a Java Swing application that manages enrollment data in-memory using `JTable` and `DefaultTableModel`.

By the end of this lab, you should be able to:

1. Create a structured Swing form.
2. Handle button events (`Add`, `Clear`, `Delete Selected`).
3. Validate user input before adding rows.
4. Update a table model dynamically.
5. Apply clean UI flow before integrating any database.

---

## Connection to Lecture

This lab reinforces the pre-database topics in Lecture 3:

- Swing fundamentals,
- layout managers,
- event-driven programming,
- validation and error handling,
- table model updates.

---

## Required Features

## Form Fields

- Student Name (`JTextField`)
- Course (`JTextField` or `JComboBox<String>`)
- Email (`JTextField`)

## Buttons

- Add
- Clear
- Delete Selected

## Table Columns

- ID
- Name
- Course
- Email

---

## Functional Requirements

1. `Add` must validate required fields (`Name`, `Course`).
2. `Email` may be optional, but if provided it must contain `@` and `.`.
3. If valid, create a `Student` object and add it to an in-memory `List<Student>`.
4. `Clear` resets all input fields.
5. `Delete Selected` removes the selected student from the list and updates the table.
6. Show clear error messages via `JOptionPane` when validation fails.
7. Table rows must be rendered from `List<Student>` (do not use table rows as the only data source).

---

## OOP Requirements (Required)

1. Create a `Student` class with fields: `id`, `name`, `course`, `email`.
2. Apply encapsulation: fields are `private` with constructors/getters/setters.
3. Keep UI logic in `EnrollmentManagerNoDB` (or equivalent UI class).
4. Keep student data logic separate from UI rendering:

- data list manipulation in methods like `addStudentToList`, `removeStudentFromList`,
- table rendering in a method like `refreshTableFromList`.

5. Use object instances (`Student`) in logic flow before displaying values in the table.

---

## Implementation Steps

1. Create frame and base panels.
2. Add input components.
3. Create `Student` model class.
4. Create `List<Student>` as in-memory storage.
5. Create `DefaultTableModel` and `JTable`.
6. Add `refreshTableFromList()` method.
7. Add button listeners.
8. Implement validation method.
9. Implement object insertion and ID generation.
10. Implement clear and delete behavior.
11. Test valid and invalid user flows.

---

## Starter Scaffold (You Complete the Logic)

```java
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EnrollmentManagerNoDB {
    // TODO: Define Student class in a separate file (id, name, course, email)

    private final JTextField nameField = new JTextField();
    private final JTextField courseField = new JTextField();
    private final JTextField emailField = new JTextField();

    private final DefaultTableModel model = new DefaultTableModel(
            new String[]{"ID", "Name", "Course", "Email"}, 0);

    private final List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EnrollmentManagerNoDB().createAndShowUI());
    }

    private void createAndShowUI() {
        JFrame frame = new JFrame("Enrollment Manager (No DB)");
        frame.setSize(760, 420);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 8, 8));
        // TODO: Add labels and text fields

        JButton addButton = new JButton("Add");
        JButton clearButton = new JButton("Clear");
        JButton deleteButton = new JButton("Delete Selected");

        JTable table = new JTable(model);

        // TODO: Wire button listeners to methods below

        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southPanel.add(deleteButton);
        frame.add(southPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void handleAdd(JFrame frame) {
        // TODO: 1) Read fields
        // TODO: 2) Validate input
        // TODO: 3) Create Student object and add to students list
        // TODO: 4) Refresh table
        // TODO: 5) Clear fields
    }

    private void handleDelete(JTable table, JFrame frame) {
        // TODO: 1) Get selected row index
        // TODO: 2) Remove corresponding Student from students list
        // TODO: 3) Refresh table
    }

    private void refreshTableFromList() {
        // TODO: Rebuild table rows from students list
    }

    private boolean validateInput(JFrame frame, String name, String course, String email) {
        // TODO: Implement required checks and messages
        return true;
    }

    private void clearFields() {
        nameField.setText("");
        courseField.setText("");
        emailField.setText("");
    }
}
```

---

## Test Checklist

1. Add with empty name -> should show error.
2. Add with empty course -> should show error.
3. Add with invalid email -> should show error.
4. Add valid input -> row appears with correct ID.
5. Clear button -> all fields empty.
6. Delete Selected without row -> warning.
7. Delete Selected with row -> row removed.

---

## Expected Output

- A working GUI app that performs Add/Clear/Delete on in-memory table data.
- IDs should increase per inserted row.
- No database usage in this activity.

---
