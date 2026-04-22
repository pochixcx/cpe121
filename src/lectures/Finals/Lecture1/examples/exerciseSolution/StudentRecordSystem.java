package lectures.Finals.Lecture1.examples.exerciseSolution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentRecordSystem {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final DateTimeFormatter DISPLAY_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final Path STORAGE_FILE = Paths.get("records.csv");

    // Exercise requirement: use HashMap as in-memory store.
    private final Map<String, Student> studentMap = new HashMap<>();

    public static void main(String[] args) {
        StudentRecordSystem app = new StudentRecordSystem();
        app.loadFromFile();
        app.startMenu();
    }

    private void startMenu() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choose option (1-6): ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    running = false;
                    saveToFile();
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 to 6.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== Student Record System (Finals Lecture 1) ===");
        System.out.println("1. Add student");
        System.out.println("2. View all students");
        System.out.println("3. Search student by ID");
        System.out.println("4. Update student");
        System.out.println("5. Delete student");
        System.out.println("6. Exit");
    }

    private void addStudent() {
        String studentId = generateStudentId();
        String name = readNonEmpty("Enter name: ");
        String course = readNonEmpty("Enter course: ");
        int yearLevel = readPositiveInt("Enter year level: ");

        Student student = new Student(studentId, name, course, yearLevel, LocalDateTime.now());
        studentMap.put(studentId, student);
        saveToFile();

        System.out.println("Student added with ID: " + studentId);
    }

    private void viewAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        List<Student> students = new ArrayList<>(studentMap.values());
        students.sort(Comparator.comparing(Student::getStudentId));

        for (Student student : students) {
            printStudent(student);
        }
    }

    private void searchStudentById() {
        String studentId = readNonEmpty("Enter student ID: ");
        Student student = studentMap.get(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        printStudent(student);
    }

    private void updateStudent() {
        String studentId = readNonEmpty("Enter student ID to update: ");
        Student student = studentMap.get(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String newName = readOptional("Enter new name (Enter to keep current): ");
        String newCourse = readOptional("Enter new course (Enter to keep current): ");
        int newYearLevel = readInt("Enter new year level (0 to keep current): ");

        if (!newName.isBlank()) {
            student.setName(newName);
        }
        if (!newCourse.isBlank()) {
            student.setCourse(newCourse);
        }
        if (newYearLevel > 0) {
            student.setYearLevel(newYearLevel);
        }

        saveToFile();
        System.out.println("Student updated successfully.");
    }

    private void deleteStudent() {
        String studentId = readNonEmpty("Enter student ID to delete: ");
        Student removed = studentMap.remove(studentId);

        if (removed == null) {
            System.out.println("Student not found.");
            return;
        }

        saveToFile();
        System.out.println("Student deleted successfully.");
    }

    private String generateStudentId() {
        int maxNumber = 0;

        for (String id : studentMap.keySet()) {
            if (id.startsWith("S")) {
                try {
                    int number = Integer.parseInt(id.substring(1));
                    maxNumber = Math.max(maxNumber, number);
                } catch (NumberFormatException ignored) {
                    // Skip malformed IDs.
                }
            }
        }

        return String.format("S%04d", maxNumber + 1);
    }

    private void loadFromFile() {
        if (!Files.exists(STORAGE_FILE)) {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(STORAGE_FILE, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromCsvLine(line);
                if (student != null) {
                    studentMap.put(student.getStudentId(), student);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load records: " + e.getMessage());
        }
    }

    private void saveToFile() {
        List<Student> students = new ArrayList<>(studentMap.values());
        students.sort(Comparator.comparing(Student::getStudentId));

        try (BufferedWriter writer = Files.newBufferedWriter(STORAGE_FILE, StandardCharsets.UTF_8)) {
            for (Student student : students) {
                writer.write(student.toCsvLine());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save records: " + e.getMessage());
        }
    }

    private void printStudent(Student student) {
        System.out.println("-----------------------------");
        System.out.println("ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Course: " + student.getCourse());
        System.out.println("Year Level: " + student.getYearLevel());
        System.out.println("Date Added: " + student.getDateTimeAdded().format(DISPLAY_FORMAT));
    }

    private String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    private String readOptional(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    private int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Please enter a positive number.");
        }
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }
}
