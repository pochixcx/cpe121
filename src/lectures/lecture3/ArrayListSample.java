package lectures.lecture3;

import java.util.ArrayList;

public class ArrayListSample {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // adding element
        list.add("Hello");
        list.add("Array");
        list.add("List");

        list.size(); // returns the size of the list
        list.get(0); // returns the element from the specified index
        list.remove(1); // removes the element from the specified index

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(23);
        numbers.add(24);
        numbers.add(2);
        numbers.add(3);
        numbers.add(22);

        // iterating array list
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

}
