# Lab Activity: CSV Persistence (Bridge to Lecture 2)

## Title

Course Enrollment Manager with CSV File Storage

## Objective

Build a Java Swing application that saves, edit and loads records using a CSV file

This activity connects:

- Previous Lab activity.

By the end of this lab, you should be able to:

1. Persist records to a CSV file.
2. Load CSV records into `JTable` when the app starts.
3. Keep GUI and file data synchronized after CRUD operations.
4. Apply safe file I/O handling with try-with-resources.

---

## Required Features

## Form Fields

- Student Name
- Course
- Email

## Buttons

- Add
- Clear
- Delete Selected
- Update Selected
- Save to CSV
- Reload from CSV

## Table Columns

- ID
- Name
- Course
- Email
- DateCreated
- DateUpdated

## File Path

Use a local file such as:

```text
data/students.csv
```

Create folder/file automatically if missing.

---

## Functional Requirements

1. On app startup, load records from CSV into `List<Student>` and render them into the table.
2. Add valid rows by creating `Student` objects with auto ID.
3. `Save to CSV` writes data from `List<Student>` to CSV.
4. `Delete Selected` removes a `Student` from the list and persists changes.
5. `Update Selected` Updates a `Student` from the list and persists changes.
6. `Reload from CSV` re-reads the file and refreshes table.
7. CSV header should be included:

```text
ID,Name,Course,Email,DateCreated,DateUpdated
```

---

## OOP Requirements (Required)

1. Create a `Student` class with fields: `id`, `name`, `course`, `email`, `dateCreated`, `dateUpdated`.
2. Apply encapsulation: private fields and getters/setters.
3. Keep UI code in `EnrollmentManagerCSV` (or equivalent view/controller class).
4. Create a separate CSV handler class (example: `StudentCsvRepository`) responsible for:

- loading `List<Student>` from file,
- saving `List<Student>` to file,
- ensuring CSV file/header exists.

5. UI class must call repository methods instead of embedding all file parsing logic inline.

---

## Test Checklist

1. Add with empty name -> should show error.
2. Add with empty course -> should show error.
3. Add with invalid email -> should show error.
4. Add valid input -> row appears with correct ID.
5. Clear button -> all fields empty.
6. Delete Selected without row -> warning.
7. Delete Selected with row -> row removed.
8. Update Selected Student -> show error for empty fields, data updated in the table and in the csv file.
9. Persistent storage -> added and updated student should appear in csv file.

---

## Expected Output

- A Swing app with persistent storage using CSV.
- Data remains after application restart.
- File handling and GUI interaction are integrated cleanly.

---
