package lectures.Finals.Lecture1.examples;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();

        students.put(101, "John");
        students.put(102, "Maria");
        students.put(103, "Peter");

        System.out.println(students);

        // Adding data
        students.put(101, "John");
        students.put(102, "Maria");
        students.put(103, "Peter");

        // Access data
        System.out.println(students.get(101));

        // Remove data
        students.remove(102);

        // Checking value if exist
        students.containsValue("Maria");

        // checking size of hashmap
        System.out.println(students.size());
    }

}

// Looping Examples

// Using keySet
// for(Integer key : students.keySet()) {
// System.out.println(key + " " + students.get(key));
// }

// Using entrySet
// for(Integer key : students.keySet()) {
// System.out.println(key + " " + students.get(key));
// }