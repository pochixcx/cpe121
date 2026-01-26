package lectures.lecture3.Examples;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassList {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> list = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("---Select Transaction---");
            System.out.println("Press 1 to add new student");
            System.out.println("Press 2 to list all students");
            System.out.println("Press 3 to exit");
            int selection = Integer.parseInt(sc.nextLine());

            if (selection == 1) {

                addStudent();

            }

            else if (selection == 2) {
                listStudent();
            }

            else if (selection == 3) {
                break;
            }

            else {
                System.out.println("Invalid selection");
            }

        }

        sc.close();
        System.out.println("Program ended");
    }

    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter student enrolled? (true/false): ");
        boolean enrolled = Boolean.parseBoolean(sc.nextLine());

        Student student = new Student(name, age, enrolled);
        list.add(student);
    }

    public static void listStudent() {
        if (list.size() == 0) {
            System.out.println("Empty student list");
        }

        else {
            System.out.println("class list size: " + list.size());
            for (int i = 0; i < list.size(); i++) {
                Student student = list.get(i);
                System.out.println("---------------------------");
                System.out.println("name: " + student.name);
                System.out.println("age: " + student.age);
                System.out.println("enrolled: " + student.enrolled);
                System.out.println("---------------------------");
            }

        }
    }

}

class Student {
    String name;
    int age;
    boolean enrolled;

    public Student(String name, int age, boolean enrolled) {

        this.name = name;
        this.age = age;
        this.enrolled = enrolled;

    }
}