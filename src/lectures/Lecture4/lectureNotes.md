# Control Structure

Programming, at its core, is the art of controlling execution. A Java program does not merely run top to bottom; it decides, repeats, reacts to failure, and sometimes calls itself. These abilities are what allow object-oriented systems to behave intelligently instead of mechanically.
<br>
This lecture explores four pillars of control flow in Java:

- Decision Control Structures

- Repetition Control Structures

- Exception Handling (Try–Catch)

- Recursion

Each section explains what the concept is, why it exists, how Java implements it, and when it should be used.

## 1. Decision Control Structures

Decision control structures allow a program to choose between multiple execution paths. Without decisions, a program is a script; with decisions, it becomes a system.

### 1.1 The if Statement

The if statement executes a block of code only if a condition evaluates to true.

```java
if (age >= 18) {
    System.out.println("Access granted");
}
```

Key concepts:

- The condition must evaluate to a boolean

- Java does not accept truthy or falsy values (unlike JavaScript)

- The code block is skipped entirely if the condition is false

Conceptually, `if` is a gatekeeper. If the condition fails, execution simply moves on.

### 1.2 The if–else Statement

An if–else structure introduces an alternative path.

```java
if (score >= 75) {
    System.out.println("Passed");
} else {
    System.out.println("Failed");
}
```

Here, the program guarantees one and only one path will execute.

This structure is essential when:

- A decision must always result in an outcome

- You want to avoid ambiguous states

### 1.3 The if–else if–else Ladder

Used when multiple conditions are possible, but only one should apply.

```java
if (grade >= 90) {
    System.out.println("Excellent");
} else if (grade >= 80) {
    System.out.println("Very Good");
} else if (grade >= 70) {
    System.out.println("Good");
} else {
    System.out.println("Needs Improvement");
}

```

Important insight:

- Conditions are checked top to bottom

- The first true condition stops further evaluation

- Order matters

### 1.4 The switch Statement

The switch statement is a structured alternative to long if–else chains when comparing a single value.

```java
int day = 3;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Invalid day");
}
```

Core ideas:

- Each `case` is a possible match

- `break` prevents fall-through

- `default` handles unexpected values

Modern Java also supports switch expressions, but understanding the classic form is foundational.

## 2. Repetition Control Structures (Loops)

Loops allow a program to repeat behavior efficiently. Without loops, programs would be repetitive, error-prone, and rigid.

### 2.1 The while Loop

A while loop checks the condition before execution.

```java
int count = 1;

while (count <= 5) {
    System.out.println(count);
    count++;
}
```

Key characteristics:

- May execute zero times

- Best when the number of iterations is unknown

- Condition-driven repetition

`Think of while as: “Repeat as long as this remains true.”`

### 2.2 The do–while Loop

A do–while loop executes at least once, then checks the condition.

```java
int number = 1;

do {
    System.out.println(number);
    number++;
} while (number <= 5);
```

This loop is useful when:

- One execution is mandatory

- Input validation is required

Conceptually: “Do this first, then decide whether to continue.”

### 2.3 The for Loop

The for loop is a compact, structured loop ideal when the number of repetitions is known.

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Anatomy:

- Initialization: int i = 1

- Condition: i <= 5

- Update: i++

This loop is preferred for:

- Counting

- Iterating over ranges

- Clear iteration logic

## 3. Exception Handling: try–catch

Programs operate in an imperfect world: invalid input, missing files, arithmetic errors. Java handles such situations using exceptions.

### 3.1 What Is an Exception?

An exception is an abnormal event that disrupts normal program flow.

Example:

```java
int result = 10 / 0; // ArithmeticException
```

If unhandled, the program terminates.

### 3.2 The try–catch Block

```java
try {
    int result = 10 / 0;
    System.out.println(result);
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

How it works:

- Code inside try is monitored

- If an exception occurs, control jumps to catch

- Normal execution resumes after the block

Exception handling is not about preventing errors, but recovering gracefully.

### 3.3 Multiple Catch Blocks

```java
try {
    String text = null;
    System.out.println(text.length());
} catch (NullPointerException e) {
    System.out.println("Null value detected");
} catch (Exception e) {
    System.out.println("General error");
}
```

Specific exceptions should always be caught before general ones.

### 3.4 The finally Block

```java
try {
    System.out.println("Processing...");
} catch (Exception e) {
    System.out.println("Error occurred");
} finally {
    System.out.println("Cleanup executed");
}
```

The finally block:

- Always executes

- Is used for cleanup (closing files, releasing resources)

## 4. Recursion

Recursion occurs when a method calls itself to solve a problem by breaking it into smaller versions of the same problem.

### 4.1 Structure of a Recursive Method

Every recursive method must have:

- Base case – stops recursion

- Recursive case – reduces the problem

### 4.2 Example: Factorial

```java
public static int factorial(int n) {
    if (n == 0) { // base case
        return 1;
    }
    return n * factorial(n - 1); // recursive case
}
```

Execution flow:

- factorial(5) calls factorial(4)

- Continues until factorial(0)

Results return back up the call stack

### 4.3 Why Use Recursion?

Recursion is powerful when dealing with:

- Tree structures

- Divide-and-conquer algorithms

- Problems naturally defined in terms of themselves

However, recursion:

- Uses more memory (call stack)

- Must be carefully designed to avoid infinite calls

Iteration is often more efficient, but recursion can be clearer and more expressive.
