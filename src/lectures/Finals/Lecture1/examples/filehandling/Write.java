package lectures.Finals.Lecture1.examples.filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("sample.txt");

            writer.write("Hello Students\n");
            writer.write("Welcome to Java Programming");

            writer.close();

            System.out.println("File written successfully");

            // Using Buffered reader
            BufferedWriter writer2 = new BufferedWriter(
                    new FileWriter("data.txt"));

            writer2.write("Java Programming");
            writer2.newLine();
            writer2.write("File Handling");

            writer2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
