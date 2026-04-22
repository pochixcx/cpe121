## Task: Student Record System

1. Student Class,
   Create a Student class with the following attributes: - studentId (String or int) — auto-generated - name (String) - course (String) - yearLevel (int) - dateTimeAdded (Date)

2. Data Storage
   Use a HashMap to store student records: - Key: studentId - Value: Student object

3. File Handling
   - Store all student records in a file for persistent storage
   - On program start: Load records from file into HashMap
   - During execution: Work only with HashMap (memory)

4. Program Features

   The system should allow users to:
   - Add student
   - View all students
   - Search student by ID
   - Update student
   - Delete student

5. Program Requirement
   - The program must use an interactive console menu
