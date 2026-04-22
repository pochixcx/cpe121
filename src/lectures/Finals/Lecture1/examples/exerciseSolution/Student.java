package lectures.Finals.Lecture1.examples.exerciseSolution;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student {
    private static final DateTimeFormatter STORAGE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private final String studentId;
    private String name;
    private String course;
    private int yearLevel;
    private final LocalDateTime dateTimeAdded;

    public Student(String studentId, String name, String course, int yearLevel, LocalDateTime dateTimeAdded) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.yearLevel = yearLevel;
        this.dateTimeAdded = dateTimeAdded;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public LocalDateTime getDateTimeAdded() {
        return dateTimeAdded;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String toCsvLine() {
        return String.join(",",
                escape(studentId),
                escape(name),
                escape(course),
                String.valueOf(yearLevel),
                dateTimeAdded.format(STORAGE_FORMAT));
    }

    public static Student fromCsvLine(String line) {
        String[] parts = line.split(",", -1);
        if (parts.length != 5) {
            return null;
        }

        try {
            String studentId = unescape(parts[0]);
            String name = unescape(parts[1]);
            String course = unescape(parts[2]);
            int yearLevel = Integer.parseInt(parts[3]);
            LocalDateTime dateTimeAdded = LocalDateTime.parse(parts[4], STORAGE_FORMAT);
            return new Student(studentId, name, course, yearLevel, dateTimeAdded);
        } catch (Exception e) {
            return null;
        }
    }

    private static String escape(String text) {
        return text.replace("\\", "\\\\").replace(",", "\\,");
    }

    private static String unescape(String text) {
        return text.replace("\\,", ",").replace("\\\\", "\\");
    }
}
