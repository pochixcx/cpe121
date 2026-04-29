package lectures.Finals.Lecture3.sqlite.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private final String url;

    public BookDao(String databasePath) {
        this.url = "jdbc:sqlite:" + databasePath;
    }

    public void ensureTableExists() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS books (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT NOT NULL,
                    author TEXT NOT NULL,
                    genre TEXT NOT NULL,
                    isbn TEXT NOT NULL UNIQUE
                )
                """;

        try (Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public int insertBook(Book book) throws SQLException {
        String sql = "INSERT INTO books(title, author, genre, isbn) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url);
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setString(4, book.getIsbn());
            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    int generatedId = keys.getInt(1);
                    book.setId(generatedId);
                    return generatedId;
                }
            }
        }

        return -1;
    }

    public List<Book> getAllBooks() throws SQLException {
        String sql = "SELECT id, title, author, genre, isbn FROM books ORDER BY id";
        List<Book> books = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url);
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("genre"),
                        resultSet.getString("isbn")));
            }
        }

        return books;
    }

    public boolean updateBookGenre(int id, String newGenre) throws SQLException {
        String sql = "UPDATE books SET genre = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url);
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newGenre);
            statement.setInt(2, id);
            return statement.executeUpdate() > 0;
        }
    }

    public boolean deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url);
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }
}