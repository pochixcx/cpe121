package lectures.lecture3.Examples;

import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] grades = new int[5];

        for (int i = 0; i < grades.length; i++) {
            System.out.print("Enter grade: ");
            grades[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }

        double average = (double) sum / grades.length;

        System.out.println("Average = " + average);

        sc.close();
    }
}
