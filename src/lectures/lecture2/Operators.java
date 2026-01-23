package lectures.lecture2;

public class Operators {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        int sum = a + b; // 13
        int diff = a - b; // 7
        int product = a * b; // 30
        int quotient = a / b; // 3 (integer division)
        int remainder = a % b; // 1

        System.out.println(sum);
        System.out.println(diff);
        System.out.println(product);
        System.out.println(quotient);
        System.out.println(remainder);

        // Assignment Operators
        int x = 5;
        x += 2; // x = x + 2 → 7
        System.out.println(x);
        x -= 1; // x = x - 1 → 6
        System.out.println(x);

        // Operator precedence

        int result = 10 + 5 * 2; // 20
        System.out.println(result);

    }
}
