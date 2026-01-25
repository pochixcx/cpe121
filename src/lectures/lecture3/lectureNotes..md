# Thiss lecture covers Array in Java

## Arrays

Array is a data structure that holds multiple data.

**Why Do We Need Arrays?**
So far, we’ve been storing one value per variable.

```Java
int score1 = 85;
int score2 = 90;
int score3 = 88;
```

This does not scale.<br>
If you have 30 students, this approach collapses under its own weight.<br>

Arrays exist to:

- Store multiple values of the same type
- Use one variable name
- Allow systematic processing using loops

_An array is a container that holds a fixed number of values of the same data type._

**What Is an Array?**

An array is:

- A reference data type
- A collection of elements
- Stored in contiguous memory
- Indexed starting at 0

```Java
int[] scores = {85, 90, 88};
```

This creates:

- One array object in memory
- Three integer elements
- One reference variable pointing to the array

**Declaring Array**

Declaration Only

```Java
int[] numbers;
```

No array exists yet — only a reference.<br>

Initialization with Size

```Java
int[] numbers = new int[5];
```

Creates an array of size 5 with default values:<br>
[0, 0, 0, 0, 0]

Initialization with Values

```Java
int[] numbers = {1, 2, 3, 4, 5};
```

Size is determined automatically.

Alternative Syntax (Less Preferred)

```java
int numbers[] = {1, 2, 3};
```

Valid Java, but avoid it for consistency.

**Accessing and Modifying Array Elements**

Arrays use index positions.

```Java
int[] numbers = {10, 20, 30};

System.out.println(numbers[0]); // 10
System.out.println(numbers[1]); // 20
System.out.println(numbers[2]); // 30
```

Changing a value:

```Java
numbers[1] = 99;
```

Now the array becomes:

```
[10, 99, 30]
```

**Array Indexing and Bounds**

Array indexes:

- Start at 0
- End at length - 1

```Java
int[] arr = new int[3];

// valid indexes: 0, 1, 2
```

Invalid access:

```
arr[3]; // Runtime error
```

This causes:

```
ArrayIndexOutOfBoundsException
```

**The length Property**

Arrays know their own size.

```Java
int[] nums = {5, 10, 15};

System.out.println(nums.length); // 3
```

Important:

- length is a property, not a method
- No parentheses

**Arrays and Loops (Natural Pairing)**
Using a for Loop

```Java
int[] nums = {10, 20, 30, 40};

for (int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}
```

Why this works:

- i matches array indexes
- nums.length prevents overflow

**Arrays Are Objects (Not Just Containers)**
Array

This is subtle but foundational.

```Java
int[] nums = {1, 2, 3};
```

What actually exists:

- One array object on the heap
- One reference variable pointing to it

**Arrays Have Fixed Size (Immutability of Length)**
Once an array is created, its size cannot change.

```Java
int[] arr = new int[3];
arr = new int[5]; // new array, old one discarded
```

Important distinction:

- You can change elements
- You cannot change length

**What Is a Multidimensional Array?**
A multidimensional array is an array whose elements are arrays themselves.

In Java:

`A 2D array is an array of 1D arrays.`

`A 3D array is an array of 2D arrays.`

This is not a metaphor. This is literal.

**Two-Dimensional (2D) Arrays**
Declaration

```java
int[][] matrix;
```

Declares a reference only.

Creation with Fixed Size

```java
int[][] matrix = new int[3][4];
```

- 3 rows
- 4 columns per row

Default values applied

Initialization with Values

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
```

Rows are inner arrays.
Columns are elements of those arrays.

Accessing Elements

```java
matrix[row][column]
matrix[0][1]; // row 0, column 1
```

Indexes start at 0.

Traversing a 2D Array

```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

- matrix.length → number of rows
- matrix[i].length → number of columns in that row

**What Is a 3D Array?**

A 3D array is an array of 2D arrays.

Think in layers:

- Depth (layers)
- Rows
- Columns

Declaration and Creation

```java
int[][][] cube = new int[2][3][4];
```

Meaning:

- 2 layers
- 3 rows per layer
- 4 columns per row

Accessing 3D Elements

```
cube[layer][row][column]
```

Example:

```java
cube[1][2][3];
```

Traversing a 3D Array

```java
for (int i = 0; i < cube.length; i++) {
    for (int j = 0; j < cube[i].length; j++) {
        for (int k = 0; k < cube[i][j].length; k++) {
            System.out.print(cube[i][j][k] + " ");
        }
        System.out.println();
    }
    System.out.println("---");
}
```

Each level requires one loop.

Memory Model

- Outer array holds references
- Inner arrays hold references
- Final arrays hold values

Because of this:

- Rows can be different sizes
- Inner arrays must be initialized before use
- NullPointerException occurs if a level is missing

**The Limitation of Arrays**

- Arrays are:
- Fixed in size
- Fast
- Simple

But real programs rarely know sizes in advance.

```java
int[] scores = new int[5]; // what if we need 6?
```

You cannot:

- Add elements
- Remove elements
- Resize the array

This is not a flaw. It’s a design trade-off.

`Arrays optimize certainty.`
`Programs often require flexibility.`

**ArrayList**

What Is an ArrayList?
<br>
An ArrayList is:

- A resizable array
- A class from the Collections Framework
- Part of java.util

Creating an ArrayList

```java
import java.itil.ArrayList;
ArrayList<Integer> numbers = new ArrayList<>();
```

Key ideas:

- Angle brackets <> → generics
- Integer not int (objects only)

Why?
Collections store reference types, not primitives.
