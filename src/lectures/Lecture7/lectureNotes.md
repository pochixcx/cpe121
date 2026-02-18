# Inheritance

Inheritance allows one class to reuse and extend another class.

A Manager is an Employee.
It inherits properties and behaviors, then adds more.

Inheritance promotes `code reuse`, but must be used carefully.

## Why Inheritance Exists

Imagine writing software for a school system.

You create a Person class:

- name

- age

- address

Later, you need:

- Student

- Teacher

- Staff

Without inheritance, you copy-paste the same fields and methods into every class. That works… until:

- A bug appears

- A rule changes

- A new field is added

Now you must update every copy. This is how software ages badly.

Inheritance exists to solve duplication and to model real-world “is-a” relationships.

**_A Student is a Person_**<br>
**_A Teacher is a Person_**

That sentence is the heart of inheritance.

## What Inheritance Is (Java Definition)

Inheritance allows a class to acquire properties and behaviors of another class.

In Java:

- A class can inherit from one class only

- Inheritance uses the keyword extends

```java
public class Person {
    protected String name;
    protected int age;
}
```

```java
public class Student extends Person {
    private String studentId;
}
```

## Superclass and Subclass

**Superclass** (Parent Class)

The class being inherited from.

**Subclass** (Child Class)

The class that inherits from another class.

Think of it as:

- Superclass → general

- Subclass → specialized

Example: Superclass

```java
public class Person {
    protected String name;
    protected int age;

    public void introduce() {
        System.out.println("Hi, I am a person.");
    }
}
```

This class is generic. It knows nothing about schools.

Example: Subclass

```java
public class Student extends Person {
    private String studentId;

    public void study() {
        System.out.println(name + " is studying.");
    }
}
```

What just happened?

- Student automatically has name, age, and introduce()
- No copying
- No duplication
- The relationship is explicit

## Extension (extends) — What It Actually Does

When you write:

```java
class Student extends Person
```

You are telling Java:

`“Student is a Person, but with additional or modified behavior.”`

This means:

- Student can use all non-private members of Person

- Student can add new methods and fields

- Student can override existing methods

## Access Control and Inheritance

Inheritance is not unlimited access.

| Modifier  | Accessible in Subclass? |
| --------- | ----------------------- |
| private   | ❌ No                   |
| default   | ⚠️ Only in same package |
| protected | ✅ Yes                  |
| public    | ✅ Yes                  |

That’s why protected exists — it’s inheritance-friendly.

## Method Overriding (Same Method, New Behavior)

Concept

Method overriding happens when:

- A subclass provides its own implementation Of a method already defined in the superclass

The method signature must be exactly the same.

Example Without Overriding

```java
Student s = new Student();
s.introduce();
```

Output:

```
Hi, I am a person.
```

But a student might want to introduce differently.

Example With Overriding

```java
public class Student extends Person {

    @Override
    public void introduce() {
        System.out.println("Hi, I am a student.");
    }
}
```

Now:

```java
Person p = new Student();
p.introduce();
```

Output:

```
Hi, I am a student.
```

Important insight:

Java decides which method to run at runtime, not compile time.

This is where inheritance quietly turns into polymorphism (we’ll revisit this formally later).

Rules of Overriding (Java Is Strict)

- Same method name
- Same parameter list
- Return type must be compatible
- Access level cannot be more restrictive
- Cannot override final methods

## Method Overloading (Same Name, Different Meaning)

Overloading is not inheritance-specific, but it often appears alongside it.

Concept

Method overloading means:

- Same method name

- Different parameter list

Java decides which method to call at compile time.

Example

```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}
```

This is not overriding.
No inheritance is required.

**Key Difference**

| Overriding            | Overloading           |
| --------------------- | --------------------- |
| Requires inheritance  | No inheritance needed |
| Same method signature | Different parameters  |
| Runtime decision      | Compile-time decision |

## Types of Inheritance (Conceptual Models)

### Monolithic (Single) Inheritance

Java’s default and only class-based inheritance.

```
Person → Student
```

One parent, one child.

Java supports this fully.

### Multiple Inheritance (Why Java Says “No”)

Multiple inheritance means:

```
Person
   ↘
    Student
   ↗
Employee
```

Two parents, one child.

Java does NOT allow this with classes.

Why?
The Diamond Problem:

- Two parents define the same method

- Java wouldn’t know which one to use

- Java chooses clarity over cleverness.

### Tandem Monolithic Inheritance (Inheritance Chain)

This is allowed:

```
Person → Employee → Manager
```

Each class extends only one class, but forms a chain.

This is extremely common and very powerful.

## Polymorphism (Through Inheritance)

We’ll go deeper later, but inheritance already sets the stage.

Concept

Polymorphism means:

- One reference type, many actual object types.

```java
Example
Person p1 = new Student();
Person p2 = new Teacher();
```

Both are Person.

Both behave differently.

This only works because of:

- Inheritance

- Method overriding

**Try it Out!**

```
Create a class Animal
Animal has this attributes:
    - String name
    - int age
    - String gender
    - move()
    - makeSound()

Create a subclass Dog, Cat, Goat and override the makeSound() method to make the specific sound of the specific Animal.
```
