package lectures.Finals.Lecture1.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExamples {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("DateTime: " + dateTime);

        DateFornatting format = new DateFornatting();
        format.example();

        ParseDate parsed = new ParseDate();
        parsed.parse();
    }
}

class DateFornatting {
    public void example() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = now.format(formatter);

        System.out.println("Formatted Date: " + formattedDate);
    }
}

// Parsing string to date
class ParseDate {
    public void parse() {

        String date = "13-04-2026";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate parsedDate = LocalDate.parse(date, formatter);

        System.out.println(parsedDate);
    }
}