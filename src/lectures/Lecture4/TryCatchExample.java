package lectures.Lecture4;

public class TryCatchExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("You tried to divide by zero. Physics disapproves.");
        } finally {
            System.out.println("This line always runs.");
        }


        String input = "abc";

        try {
            int value = Integer.parseInt(input);
            System.out.println("Parsed value: " + value);
        } catch (NumberFormatException e) {
            System.out.println("That is not a valid number.");
        }


    }
}
