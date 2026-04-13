package lectures.Finals.Lecture1.examples;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        GradeManager manager = new GradeManager();

        manager.demo();
    }

}

class GradeManager {
    // ALWAYS program to the interface (List)
    private List<String> studentNames = new ArrayList<>();

    public void demo() {
        studentNames.add("Alice"); // Append
        studentNames.add(0, "Bob"); // Insert at beginning (expensive!)
        String name = studentNames.get(1); // Alice
        studentNames.remove("Alice");

        // Iteration - modern style
        studentNames.forEach(n -> System.out.println(n));

        // Or using enhanced for-loop
        for (String s : studentNames) {
            System.out.println(s);
        }
    }
}