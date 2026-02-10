package lectures.Lecture5.examples.enrollmentSystem;

public class UniversityApp {
    public static void main(String[] args) {
        Course oop = new Course("CPE121", "Object-Oriented Programming");
        Student student = new Student("Ana");

        student.enroll(oop);
    }
}
