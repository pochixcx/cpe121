package lectures.Lecture4;

public class RecursionExample {
    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is " + result);
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1; // base case: stop here
        }
        return n *
         factorial(n - 1); // recursive call
    }

    
}

class RecursiveArraySum {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(sum(numbers, numbers.length));
    }

    static int sum(int[] arr, int length) {
        if (length == 0) {
            return 0;
        }
        return arr[length - 1] + sum(arr, length - 1);
    }
}

