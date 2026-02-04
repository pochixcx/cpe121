package exerciseSolutions;

public class Assignment1 {
    public static void main(String[] args){
        exercise1();
        exercise2();
    }
/*
* Exercise 1 Search and average
*    Create an int array with values: 5, 8, 12, 20, 7, 3
*   Find and print:
*       Average
*       Largest value
*       Index of value 12
*/

public static void exercise1(){
    int[] arr = {5,8,12,20,7,3};

    int largest = 0;
    double average= 0;
    int index = 0;

    for(int i = 0 ; i < arr.length; i++){
        average =+ (double) arr[i];

        if(arr[i] >= largest) {
            largest = arr[i];
        }

        if(arr[i] == 12){
            index = i;
        }
    }

    System.out.println("largest value: " + largest );
    System.out.println("index of 12: " + index );
    System.out.println( "average: " + average/arr.length);
}
   

    // Exercise 2 Count even and calculate the sum of even numbers
    // Given the following array 5, 8, 12, 20, 7, 3, 12, 24, 11, 17

    // Count how many even numbers in the array.
    // calculate the sum of even numbers

    public static void exercise2(){
        int[] arr = {5, 8, 12, 20, 7, 3, 12, 24, 11, 17};

        int count = 0;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                count+=1;
                sum += arr[i];
            }
        }

        System.out.println("Total even numbers: " + count);
        System.out.println("Sum of even numbers: " + sum);
    }
}
