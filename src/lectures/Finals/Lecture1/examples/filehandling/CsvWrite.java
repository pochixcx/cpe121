package lectures.Finals.Lecture1.examples.filehandling;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWrite {
    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("students.csv");

            writer.append("Name,Age,Course\n");

            writer.append("John,21,BSIT\n");
            writer.append("Maria,20,BSCS\n");
            writer.append("Peter,22,BSIT\n");

            writer.close();

            System.out.println("CSV File Created");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
