package lectures.Finals.Lecture3.sqlite.examples;

import java.sql.SQLException;
import java.util.List;

public class BookCrudDemo {
    public static void main(String[] args) {
        BookDao dao = new BookDao("library_books.db");

        try {
            dao.ensureTableExists();
            System.out.println("Database ready.\n");

            String runId = Long.toString(System.currentTimeMillis());
            Book first = new Book("Clean Code", "Robert C. Martin", "Software Engineering", createIsbn(runId, 1));
            Book second = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", createIsbn(runId, 2));

            int firstId = dao.insertBook(first);
            int secondId = dao.insertBook(second);

            System.out.println("After create:");
            printBooks(dao.getAllBooks());

            dao.updateBookGenre(firstId, "Programming");
            System.out.println("After update:");
            printBooks(dao.getAllBooks());

            dao.deleteBook(secondId);
            System.out.println("After delete:");
            printBooks(dao.getAllBooks());
        } catch (SQLException exception) {
            System.out.println("Database error: " + exception.getMessage());
            if (exception.getMessage() != null && exception.getMessage().contains("No suitable driver found")) {
                System.out.println("Make sure the SQLite JDBC driver is available at runtime.");
            }
        }
    }

    private static String createIsbn(String runId, int sequence) {
        return "DEMO-ISBN-" + runId + "-" + sequence;
    }

    private static void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.\n");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
    }
}