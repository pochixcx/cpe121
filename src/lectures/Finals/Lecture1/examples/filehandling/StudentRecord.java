package lectures.Finals.Lecture1.examples.filehandling;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentRecord {

    public static void main(String[] args) {

        try {

            FileWriter writer = new FileWriter("records.csv", true);

            LocalDate today = LocalDate.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            writer.append("John,BSIT," +
                    today.format(formatter) + "\n");

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}