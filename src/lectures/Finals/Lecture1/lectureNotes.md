# Lecture 1

## ArrayList and HashMaps

Before diving in, let's discuss first what is Java Collections

Java Collection Framework (JCF) is a set of classes and interfaces that provide ready-made data structures to store and manipulate groups of objects efficiently.

Java provides collection interfaces like List, Set, Map, and Queue, with ready-made classes such as ArrayList, HashSet, HashMap, and PriorityQueue, so you don’t have to write data-handling code from scratch.

### List

**What is a `List`?**
- An ordered collection (sequence).
- Allows duplicates.
- Elements can be accessed by integer index (position).

#### Key Methods

| Method            | Description           | Return Type |
| ----------------- | --------------------- |-------------|
|add(E e)	        |Append element         | boolean     |
|add(int index, E e)|	Insert at position  | void        |
|get(int index)	    |Retrieve element	    | E           |
|set(int index, E e)|Replace element        | E (old value)|
|remove(int index)  |	Remove by position  | E           |
|remove(Object o)   |	Remove by value     | boolean     |
|size()	            |Number of elements     |	int       |
|isEmpty()	        |Check if empty         |	boolean   |
|clear()	        |Remove all             |	void      |
|contains(Object o) |	Check existence     |	boolean   |
|indexOf(Object o)  |	Find first index    |	int       |
|iterator()         |	Get iterator        |	Iterator<E>|

List is an interface that provides a standardized behavior for every list implementation where it serves as a blueprint.

#### List is an interface so we can't instantiate it.

```java
// Wrong
List<String> list = new List<>();  // Compile error

// Correct – use concrete class that implements List
List<String> list = new ArrayList<>();   // Most common
List<String> list2 = new LinkedList<>(); // Alternative
```

### ArrayList - Concrete Implementation of List interface

ArrayList is a resizable array. Under the hood, it manages a normal array that grows when full 

**The Problem with Regular Arrays**<br>
- Fixed size. You have to know how many students you have before you create the array.
- Inserting/deleting in the middle is expensive (shifting elements).

**ArrayList - A Resizable Array**<br>
- Think of it as a managed array that grows/shrinks automatically.
- Under the hood: It maintains a normal array. When it gets full, it creates a new, larger array (typically 1.5x the size) and copies elements over.

##### Key Concepts for Students
- Generics: ArrayList<Student> not ArrayList. The latter is "raw" and loses type safety.
- Performance: Access by index (get(i)) is O(1) - fast. Insert/delete in the middle is O(n) - slower.
- When to use: When order matters, you need fast iteration, and you do mostly reads/appends.

### Map

**What is a Map?**
- An object that maps keys to values.
- No duplicate keys (each key maps to at most one value).
- Not a Collection (it's separate hierarchy).
- Order depends on implementation: HashMap (no order), LinkedHashMap (insertion order), TreeMap (sorted order).


| Method            | Description           |
| ----------------- | --------------------- |
| put(K key, V value)|	Associates key with value (overwrites old)
|get(Object key)	|Returns value or null
|getOrDefault(key, |defaultValue)	Safe get
|remove(Object key)	|Removes mapping
|containsKey(Object key)|	Checks key existence
|containsValue(Object value)|	Checks value existence (expensive, O(n))
|keySet()	|Returns Set<K> of keys
|values()	|Returns Collection<V> of values
|entrySet()	|Returns Set<Map.Entry<K,V>>
|size(), isEmpty(), clear()|	As expected
|putIfAbsent(key, value)	|Only puts if key not already mapped
|computeIfAbsent(key, mappingFunction)|	Compute value only if absent (very useful)

#### HashMap - The Key-Value Store
**The Concept**
- No order. You don't access by index; you access by a key.
- Each key maps to exactly one value.
- Under the hood: Array of "buckets". The key's hashCode() determines which bucket. equals() finds the exact match within the bucket.

**When to use:**
- Lookups by ID (e.g., student ID -> Student object)
- Counting frequencies (word count, grade distribution)
- Caching

## Date Formatting

Working with dates is very common in Java applications such as:

- Logging systems
- Reports generation
- File timestamps
- User input processing
- Database records

Java provides two main approaches:
| Approach   | Package                              | Recommended             |
| ---------- | ------------------------------------ | ----------------------- |
| Old API    | `java.util.Date`, `SimpleDateFormat` | ❌ Not recommended       |
| Modern API | `java.time.*`                        | ✅ Recommended (Java 8+) |

Java Date & Time Classes (Modern API)

Package: java.time

Common Classes:
| Class               | Purpose            |
| ------------------- | ------------------ |
| `LocalDate`         | Date only          |
| `LocalTime`         | Time only          |
| `LocalDateTime`     | Date and time      |
| `DateTimeFormatter` | Format date/time   |
| `ZonedDateTime`     | Date with timezone |

#### Getting Current Date and Time

```java
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
```

#### DateFormatting using DateTimeFormatter

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("pattern");
```

#### Common Date Format Patterns
| Pattern | Meaning    | Example |
| ------- | ---------- | ------- |
| yyyy    | Year       | 2026    |
| MM      | Month      | 04      |
| dd      | Day        | 13      |
| HH      | Hour (24)  | 14      |
| hh      | Hour (12)  | 02      |
| mm      | Minutes    | 30      |
| ss      | Seconds    | 45      |
| a       | AM/PM      | PM      |
| EEEE    | Day Name   | Monday  |
| MMMM    | Month Name | April   |


#### more format examples
```java
DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
DateTimeFormatter f2 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
DateTimeFormatter f3 = DateTimeFormatter.ofPattern("EEEE");

System.out.println(now.format(f1));
System.out.println(now.format(f2));
System.out.println(now.format(f3));
```

## File Reading and Writing

Java supports file handling and it provides classes for file handling:
| Class          | Purpose           |
| -------------- | ----------------- |
| FileWriter     | Write file        |
| FileReader     | Read file         |
| BufferedWriter | Efficient writing |
| BufferedReader | Efficient reading |
| PrintWriter    | Formatted writing |

#### Writing to text file
```java
 FileWriter writer = new FileWriter("sample.txt");

writer.write("Hello Students\n");
writer.write("Welcome to Java Programming");

writer.close();

System.out.println("File written successfully");

// Using Buffered reader
BufferedWriter writer2 = new BufferedWriter(new FileWriter("data.txt"));

writer2.write("Java Programming");
writer2.newLine();
writer2.write("File Handling");

```

**FileWriter vs BufferedWriter**

When to Use FileWriter Only

Use FileWriter only when:
- Writing very small data
- Simple programs
- Learning basics

When to Use BufferedWriter

Use BufferedWriter when:
- Writing large files
- Writing loops
- Writing logs
- Writing CSV files
- Professional applications

When using FileWriter, every write operation:

- Sends data directly to disk
- Disk operation happens every time
- Slower performance

BufferedWriter stores data in memory first (buffer) and writes to file only when buffer is full or closed.
- Data stored in memory buffer
- Written to disk once
- Much faster

BufferedWriter methods
| Method    | Description         |
| --------- | ------------------- |
| write()   | Write text          |
| newLine() | Add new line        |
| flush()   | Force write to file |
| close()   | Close file          |


#### Working with CSV Files
What is CSV?

CSV = Comma Separated Values

Example:
```
Name,Age,Course
John,21,BSIT
Maria,20,BSCS
```

#### Writing CSV File
```java
FileWriter writer = new FileWriter("students.csv");

writer.append("Name,Age,Course\n");

writer.append("John,21,BSIT\n");
writer.append("Maria,20,BSCS\n");
writer.append("Peter,22,BSIT\n");

writer.close();
```

#### Reading to CSV file
```java
String line;

        
BufferedReader reader = new BufferedReader( new FileReader("students.csv"));

while((line = reader.readLine()) != null) {

    String[] data = line.split(",");

    System.out.println("Name: " + data[0]);
    System.out.println("Age: " + data[1]);
    System.out.println("Course: " + data[2]);
    System.out.println();
    }

reader.close();
```