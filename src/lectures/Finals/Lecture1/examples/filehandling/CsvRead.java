package lectures.Finals.Lecture1.examples.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvRead {
    public static void main(String[] args) {

        String line;

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("students.csv"));

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println("Name: " + data[0]);
                System.out.println("Age: " + data[1]);
                System.out.println("Course: " + data[2]);
                System.out.println();
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
