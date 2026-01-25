package lectures.lecture3;

public class Array {
    public static void main(String[] args) {

        // Array examples
        int[] scores = { 85, 90, 88 };
        System.out.println(scores[0]);
        System.out.println(scores[1]);
        System.out.println(scores[2]);

        int[] age = new int[3];
        age[0] = 23;
        age[1] = 25;
        age[2] = 19;
        System.out.println(age[0]);
        System.out.println(age[1]);
        System.out.println(age[2]);

        // The length property
        System.out.println("array age length is: " + age.length);

        // Printing array values using a loop
        for (int i = 0; i < age.length; i++) {
            System.out.println(age[i]);
        }

    }
}