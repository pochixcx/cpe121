package lectures.lec2;

import java.util.Scanner;

public class IO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creates an instance of Scanner class and assigns it into a
                                                  // variable.

        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Reads a full line string

        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Reads an integer

        System.out.print("Single?: ");
        boolean status = scanner.nextBoolean(); // Reads an boolean

        System.out.print("ahow much money do you have?: ");
        double money = scanner.nextDouble(); // Reads double value

        System.out.println("Hello " + name + ", you are " + age + " years old." + " Single? " + status + " You have "
                + money + "left in ypur pocket.");

    }
}