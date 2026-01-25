package lectures.lecture3;

public class MultidemensionArray {
    public static void main(String[] args) {

        // 2D Array example
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        System.out.println(matrix[0][0]);
        System.out.println(matrix[0][1]);
        System.out.println(matrix[1][1]);

        // 3D Array example

        int[][][] numbers = {
                { // layer 0
                        { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 }
                },
                { // layer 1
                        { 13, 14, 15, 16 },
                        { 17, 18, 19, 20 },
                        { 21, 22, 23, 24 }
                }
        };

        System.out.println(numbers[1][0][2]);

        // Traversing 3D Array
        for (int i = 0; i < numbers.length; i++) { // layers
            for (int j = 0; j < numbers[i].length; j++) { // rows
                for (int k = 0; k < numbers[i][j].length; k++) { // columns
                    System.out.println(numbers[i][j][k]);
                }
            }
        }

    }
}
