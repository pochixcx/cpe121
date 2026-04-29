# Setup Guide: SQLite JDBC for Plain Java Projects

## Important Idea

SQLite is file-based.

- No need to MySQL or PostgreSQL setup
- No need for a separate SQLite server running
- students only need the SQLite JDBC driver jar and a Java project

The Java application will create or open a `.db` file directly.

## What Students Need

1. Java JDK installed
2. a plain Java project
3. the SQLite JDBC driver jar
4. Java code that uses `jdbc:sqlite:` as the connection URL

## Where to Download the JDBC Driver

Students should download the SQLite JDBC driver made by Xerial.

Dependency name:

```text
org.xerial:sqlite-jdbc
```

Recommended download sources:

1. Maven Central
2. Xerial SQLite JDBC GitHub releases

The downloaded file will look similar to this:

```text
sqlite-jdbc-3.49.1.0.jar
```

## Current Example Setup in This Lesson

This lesson uses a plain Java setup.

- source files are under `src`
- compiled classes go to `bin`
- external jars are stored in `lib`
- the SQLite driver jar is added as a library dependency

In the current example, the driver jar is placed in:

```text
lib/sqlite-jdbc-3.49.1.0.jar
```

The database file is created automatically when the Java program runs.

Example database file:

```text
library_books.db
```

## VS Code Setup

1. Create a `lib` folder in the project if it does not exist.
2. Put the downloaded SQLite JDBC jar inside `lib`.
3. Make sure `.vscode/settings.json` includes the referenced library path.

Example:

```json
{
  "java.project.sourcePaths": ["src"],
  "java.project.outputPath": "bin",
  "java.project.referencedLibraries": ["lib/**/*.jar"]
}
```

After adding the jar, students may need to reload the Java project or restart VS Code once.

## Eclipse Setup

1. Right-click the project.
2. Select `Build Path`.
3. Select `Configure Build Path`.
4. Open the `Libraries` tab.
5. Click `Add External JARs...`.
6. Choose the downloaded `sqlite-jdbc` jar.
7. Apply the changes and run the project.

## NetBeans Setup

1. Right-click the project.
2. Select `Properties`.
3. Open `Libraries`.
4. Click `Add JAR/Folder`.
5. Choose the downloaded `sqlite-jdbc` jar.
6. Apply the changes and run the project.

## IntelliJ IDEA Setup

1. Right-click the project.
2. Open `Project Structure` or `Module Settings`.
3. Select `Modules`.
4. Open the `Dependencies` tab.
5. Click `+`.
6. Choose `JARs or directories`.
7. Select the downloaded `sqlite-jdbc` jar.
8. Apply the changes and run the project.

## Minimum Code Pattern

Students need a connection URL that points to SQLite.

Example:

```java
String url = "jdbc:sqlite:library_books.db";
```

This means:

- `jdbc:sqlite:` tells JDBC to use SQLite
- `library_books.db` is the database file name
- if the file does not exist, SQLite can create it

## Database Integration Checklist

Before running the project, students should confirm all items below.

1. JDK is installed correctly.
2. The `sqlite-jdbc` jar is downloaded.
3. The jar is added to the project libraries or classpath.
4. The JDBC URL starts with `jdbc:sqlite:`.
5. The table creation method is called before insert, update, or select operations.
6. SQL statements use `PreparedStatement` instead of string concatenation.
7. Database code uses try-with-resources for cleanup.
8. The project runs with the JDBC jar included at runtime.

## Terminal Example for Plain Java

Compile:

```powershell
javac -cp "c:\path\to\project\lib\*" -d bin src\path\to\YourClass.java
```

Run:

```powershell
java -cp "c:\path\to\project\bin;c:\path\to\project\lib\*" your.package.MainClass
```

## Common Errors and Causes

### No suitable driver found

Cause:

- the JDBC jar was not added correctly
- the runtime classpath does not include the jar

### no such table

Cause:

- the table creation method was not called before CRUD operations

### unable to open database file

Cause:

- invalid database path
- missing permission to create or open the file

### UNIQUE constraint failed

Cause:

- duplicate value inserted into a column marked `UNIQUE`
