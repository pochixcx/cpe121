# Additional Reading: SQLite, JDBC, and CRUD

## Course Materials to Revisit First

1. `src/lectures/Finals/Lecture3/LectureNotes.md`
   Focus on the sections about SQLite, JDBC, `PreparedStatement`, and DAO integration.

2. `src/lectures/Finals/Lecture3/InstructorGuide.md`
   Focus on the teaching sequence for SQLite fundamentals and guided integration.

3. `src/lectures/Finals/Lecture3/activities/LabActivity_CSVPersistence.md`
   Use this to review how persistence was first introduced before the database version.

## Suggested Technical Reading Topics

### JDBC Basics

Read about:

- `DriverManager`
- `Connection`
- `PreparedStatement`
- `ResultSet`
- try-with-resources for database code

### SQLite Basics

Read about:

- SQLite as a file-based relational database
- creating tables
- primary keys
- text columns
- simple insert, select, update, and delete statements

### CRUD Review

Make sure the following meanings are clear:

- Create = insert a new record
- Read = retrieve and display records
- Update = edit an existing record
- Delete = remove an existing record

### DAO Pattern

Review why the DAO pattern is useful:

- SQL stays outside the UI class
- logic becomes easier to test and maintain
- the database layer can change without rewriting the form flow

## Recommended Self-Check Questions

1. What does the SQLite JDBC dependency provide?
2. Why is `PreparedStatement` preferred over plain string concatenation?
3. What is the role of a DAO in this lesson?
4. How does Read differ from Create in terms of JDBC objects used?
5. Why is refreshing the table after a successful operation important?

## Suggested Next Practice

1. Write a small method that inserts one student into SQLite.
2. Write a second method that reads all students and prints them.
3. Replace a CSV repository with a DAO in the enrollment manager.
