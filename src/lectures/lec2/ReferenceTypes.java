package lectures.lec2;

public class ReferenceTypes {
    public static void main(String[] args) {
        String s1 = "Hello"; // s1 refers to a String object in heap
        String s2 = s1; // s2 refers to the same object as s1

        System.out.println(s1); // Hello
        System.out.println(s2); // Hello

        System.out.println(s1 == s2); // true (both point to same object)
    }
}

class ReferenceExample3 {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3 }; // arr1 refers to array object in heap
        int[] arr2 = arr1; // arr2 refers to same array

        arr2[0] = 100;

        System.out.println(arr1[0]); // 100
        System.out.println(arr2[0]); // 100
    }
}
