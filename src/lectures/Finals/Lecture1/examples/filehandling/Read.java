package lectures.Finals.Lecture1.examples.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("data.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
