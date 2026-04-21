# Pre-Database GUI Examples (Lecture 3)

These examples are designed for student practice before database integration.

## Example List

1. `BasicWindowExample.java`

- Creates a simple Swing window.
- Focus: `JFrame`, basic setup, EDT startup.

2. `LayoutManagersExample.java`

- Demonstrates `FlowLayout`, `GridLayout`, and `BorderLayout` together.
- Focus: layout behavior and component placement.

3. `ButtonEventExample.java`

- Uses button clicks to update a label.
- Focus: `ActionListener` and event-driven programming.

4. `FormValidationExample.java`

- Validates required fields and email format.
- Focus: input checking and `JOptionPane` feedback.

5. `TableModelExample.java`

- Uses `JTable` with `DefaultTableModel` and sample data.
- Focus: table display and model updates.

6. `EnrollmentManagerNoDB.java`

- Mini enrollment app with Add/Clear/Delete using in-memory table data.
- Focus: full pre-database flow (UI + validation + events + table refresh).

## How to Run

Compile and run any file individually.

Example:

```bash
cd src
javac lectures/Finals/Lecture3/examples/preDatabase/BasicWindowExample.java
java lectures.Finals.Lecture3.examples.preDatabase.BasicWindowExample
```

Repeat for the other programs by changing file/class names.

## Suggested Student Order

Run examples in the listed order above.

This order builds confidence before moving to SQLite integration.
