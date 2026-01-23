# This lecture provides an introduction to core Java programming concepts, including input and output mechanisms, comments, statements, and program blocks, as well as identifiers, keywords, literals, data types, operators, and operator precedence.

## Input and Output (I/O)

**What is Input and Output?**
A program is a very obedient machine.
It waits for input, processes it, and produces output.

`Input` → data coming into the program<br>
`Output` → data going out of the program
<br>

_Output in Java_<br>
Java prints output using `System.out.`:<br>

```Java
System.out.println("Hello World");
```

Breakdown:
<br>

- System → built-in Java class
- out → output stream (where text is sent)
- println → print line (prints text, then moves to a new line), in here we pass the data as the argument that we are going to print.

Other variant:<br>

```Java
System.out.print("Hello World");
System.out.print("Hello World");
```

<br>

The output is printed on the same line:<br>
`Hello WorldHello World`

## Using Scanner for Input

**Why Scanner Exists ?**
Java does not read keyboard input automatically.
The Scanner class in Java, part of the java.util package, is a high-level input utility designed to simplify the process of reading input from various sources and has the ability to parse primitive data types and strings directly from the input stream.
<br>
Usage:

```Java
import java.util.Scanner;
```

import the `Scanner` package

```Java
Scanner scanner = new Scanner(System.in);
```

- System.in → standard input (keyboard)
- scanner → variable name (can be anything sensible)

```Java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter your name: ");
String name = scanner.nextLine();

System.out.print("Enter your age: ");
int age = scanner.nextInt();

System.out.println("Hello " + name + ", you are " + age + " years old.");
```

**Common Scanner methods:**

- nextLine() → reads a full line (String)
- nextInt() → reads an integer
- nextDouble() → reads a decimal number
- nextBoolean() → reads true/false

## Comments, Statements, Blocks, Identifiers, Keywords, Literals

**These are the grammar rules of Java.**
<br>

**Comments (Ignored by Java)**
Used for explaining code to humans.

```Java
// This is a single-line comment

/*
 This is a
 multi-line comment
 */
```

Java completely ignores comments.

**Statements**
A statement is a complete instruction.

```Java
int x = 5;
System.out.println(x);
```

Most Java statements end with a semicolon (;)
Think of it as a period in a sentence.

**Blocks**
A block is a group of statements enclosed in { }.

```Java
{
    int x = 10;
    System.out.println(x);
}
```

**Identifiers**
Identifiers are names you give to:

- variables
- methods
- classes
  <br>
  Examples:

```Java
int age;
double salary;
String studentName;
```

Rules:

- Must start with a letter, \_, or $
- Cannot start with a number
- Cannot be a Java keyword
- Case-sensitive (age ≠ Age)

Best practice:

- Use camelCase for variables and methods
  `studentAge`, `totalScore`.

**Keywords**
Keywords are reserved words in Java.
You cannot use them as identifiers.

Examples:

- int
- double
- class
- public
- static
- void
- if, else, while

Java uses keywords to define structure and behavior.

**Literals**
Literals are fixed values written directly in code.

```Java
int age =10        // integer literal
double price = 3.14      // double literal
char character = 'A'       // char literal
String str = "Hello"   // string literal
boolean bool = true      // boolean literal
```

**They represent raw data.**
Data Types and Variables
Variables

A variable is a named storage location for data.

`int age = 20;`

- int → data type
- age → variable name
- 20 → value

Java is statically typed, meaning:
`Every variable must have a type before it is used.`

## Data Types

**Data Types**
A data type defines the kind of data a variable can store and determines how that data is represented, processed, and stored in computer memory.

Before Java, before computers, imagine telling someone:

`“Store this thing.”`
<br>
Their next question is unavoidable:
<br>
`“What kind of thing?”`

_A number?_

_A word?_

_A yes-or-no value?_

_A single letter?_

**What a Data Type Really Is**

- A data type answers three fundamental questions:
- How much memory should be allocated?
- How should the bits be interpreted?
- What operations are allowed on this data?

Example:

```Java
int x = 10;
```

By writing int, you’re telling Java:

- Reserve 32 bits of memory
- Interpret those bits as a whole number
- Allow arithmetic operations like +, -, \*, /

Without data types, Java would be guessing.
Java does not like guessing. Java likes contracts.

**Why Java Is Strict About Data Types**

Java is statically typed, meaning:

- Data types are checked at compile time
- Errors are caught before the program runs

This leads to:

- Fewer runtime crashes
- Better performance
- Clearer, self-documenting code

In short:
Data types are how Java protects you from your future self.

**Two Major Categories of Data Types in Java**

Java divides data types into two families:

- Primitive Data Types
- Reference Data Types
  They look similar when used, but they behave very differently under the hood.

**Primitive Data Types**
What Are Primitive Types?
Primitive types store actual values directly.
They are:

- Simple
- Fixed in size
- Fast
- Not objects

Examples:

```Java
int age = 20;
double price = 99.99;
boolean isActive = true;
char grade = 'A';
```

**List of Primitive types in Java:**

```
| Data Type  | Size       | Description             | Example             |
|------------|-----------|--------------------------|---------------------|
| byte       | 1 byte    | Very small integer       | byte b = 10;        |
| short      | 2 bytes   | Small integer            | short s = 100;      |
| int        | 4 bytes   | Integer (most used)      | int x = 1000;       |
| long       | 8 bytes   | Large integer            | long l = 100000L;   |
| float      | 4 bytes   | Decimal (less precision) | float f = 3.14f;    |
| double     | 8 bytes   | Decimal (high precision) | double d = 3.14159; |
| char       | 2 bytes   | Single Unicode character | char c = 'A';       |
| boolean    | 1 bit*    | True/False value         | boolean flag = true;|

*Size of boolean is JVM-dependent, but logically stores 1 bit.
```

Key Characteristics of Primitive Types:

- Store the actual value
- Cannot be null
- Have no methods
- Very memory-efficient

**Reference Data Types**

**What Are Reference Types?**

Reference types do not store the actual value.

Instead, they store a reference (address) pointing to data stored elsewhere in memory.

Think:

- Primitive → value in the box
- Reference → address of the box

Examples:

```Java
String name = "Alice";
Scanner scanner = new Scanner(System.in);
int[] numbers = {1, 2, 3};
```

Common Reference Types:

- String
- Arrays (int[], String[])
- Classes (Scanner, Student, Car)
- Interfaces

## Operators and Operator Precedence

**Operators**
Operators tell Java what to do with values.

Examples:

```Java
int a = 10;
int b = 3;

int sum = a + b;        // 13
int diff = a - b;       // 7
int product = a * b;    // 30
int quotient = a / b;   // 3 (integer division)
int remainder = a % b;  // 1
```

Assignment Operators:

```Java
int x = 5;
x += 2;  // x = x + 2 → 7
x -= 1;  // x = x - 1 → 6
```

Comparison Operators:
Used in decision making.

```Java
a == b   // equal to
a != b   // not equal
a > b
a < b
a >= b
a <= b
```

Result is always a boolean.

**Logical Operators**
Used with boolean values.

```Java
&&   // AND
||   // OR
!    // NOT
```

Example:
boolean isAdult = age >= 18 && age < 60;

**Operator Precedence**
Java follows mathematical order of operations.

Order (simplified):

- `() parentheses`
- `* / %`
- `+ -`

Example:

int result = 10 + 5 \* 2; // 20
