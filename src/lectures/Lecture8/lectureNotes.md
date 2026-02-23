# Abstraction and Polymorphism

## ABSTRACTION

_What Abstraction Actually Means? _

`Abstraction is the art of hiding complexity and exposing only what the user needs to know.`

In programming terms:

- We define what an object can do

- We hide how it does it

This mirrors real life:

- You know what a remote control does (change channel, adjust volume)

- You do not care how infrared signals work

In OOP:

- The interface / abstract class defines behavior

- The concrete class provides the implementation

Abstraction answers the question:

`“What should this object be able to do?”`

_Why Abstraction Exists (Very Important)_

Abstraction helps us:

- Reduce complexity

- Enforce consistency

- Enable loose coupling

- Support polymorphism

- Make systems easier to extend and maintain

Without abstraction, systems become rigid and fragile.

_Ways to Achieve Abstraction in Java_

Java provides two mechanisms:

- Abstract Classes

- Interfaces

They serve similar goals but have different rules and use cases.

## ABSTRACT CLASSES

An abstract class:

Cannot be instantiated

May contain:

- Abstract methods (no body)

- Concrete methods (with body)

- Acts as a partial blueprint

Syntax

```java
abstract class Animal {
    abstract void makeSound();

    void breathe() {
        System.out.println("Animal is breathing");
    }
}
```

## Abstract Methods

An abstract method:

- Has no implementation

- Forces subclasses to implement it

```java
abstract void makeSound();
```

Any non-abstract subclass must override this method.

## Concrete Implementation Example

```java
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}
```

```java
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}
```

Usage:

```java
Animal a1 = new Dog();
Animal a2 = new Cat();

a1.makeSound(); // Dog barks
a2.makeSound(); // Cat meows
```

Notice:

We never instantiate Animal

We program to the abstract type, not the concrete class

Rules of Abstract Classes

- Can have instance variables

- Can have constructors

- Can have concrete methods

- Can have abstract methods

- A class can extend only one abstract class

## INTERFACES

What Is an Interface?

An interface is a pure contract.

It defines:

- What a class must do

- Not how it does it

Think of it as a promise.

Interface Syntax

```java
interface Flyable {
    void fly();
}
```

All methods are implicitly:

- public

- abstract (unless default or static)

Implementing an Interface

```java
class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane is flying");
    }
}
```

Usage:

```java
Flyable f1 = new Bird();
Flyable f2 = new Airplane();

f1.fly();
f2.fly();
```

## Key Difference: Abstract Class vs Interface

| Feature              | Abstract Class      | Interface         |
| -------------------- | ------------------- | ----------------- |
| Methods              | Abstract + Concrete | Abstract (mostly) |
| Fields               | Instance variables  | Constants only    |
| Constructors         | Yes                 | No                |
| Multiple inheritance | No                  | Yes               |
| Purpose              | “Is-a” base class   | Capability / role |

## When to Use Abstraction

Use abstract class when:

- Classes are closely related

- You want shared code

Use interface when:

- Classes are unrelated

- You want multiple inheritance of behavior

- You define capabilities (e.g., Runnable, Comparable)

## POLYMORPHISM

What Polymorphism Means

Polymorphism means:

- One interface, many behaviors

Same method name<br>
Different behavior<br>
Based on the object type at runtime<br>

The word literally means:

Poly = many

Morphism = forms

## Types of Polymorphism in Java

Java supports:

**Compile-time polymorphism (Method Overloading)**

**Runtime polymorphism (Method Overriding)**

## RUNTIME POLYMORPHISM (CORE OOP)

Method Overriding Recap

A subclass overrides a superclass method:

- Same method signature

- Same return type (or covariant)

- Access level cannot be more restrictive

Example:

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat Meows");
    }
}
```

Polymorphism in Action

```java
Animal animal = new Dog();
animal.makeSound();
```

Output:

```
Dog barks
```

Why?

Method call is resolved at runtime

Based on the actual object, not reference type

This is dynamic method dispatch.

## Multiple Objects, One Reference Type

```java
Animal[] animals = {
    new Dog(),
    new Cat(),
    new Dog()
};

for (Animal a : animals) {
    a.makeSound();
}

```

Each object responds according to its own implementation.

## Polymorphism with Interfaces\

```java
interface Payment {
    void pay(double amount);
}

class CashPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " in cash");
    }
}

class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using card");
    }
}
```

Usage:

```java
Payment payment = new CardPayment();
payment.pay(500);
```

## Why Polymorphism Is Powerful

Polymorphism allows:

- Flexible code

- Easy extension

- Minimal modification

Example:

```java
void processPayment(Payment payment) {
    payment.pay(1000);
}
```

Any new payment method works without changing this method.

That’s industrial-strength OOP.

## COMBINING ABSTRACTION + POLYMORPHISM

Abstraction defines the contract<br>
Polymorphism delivers the behavior<br>

Example:

```java
abstract class Shape {
    abstract double area();
}
class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}
class Rectangle extends Shape {
    double length, width;

    Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    double area() {
        return length * width;
    }
}
```

Usage:

```java
Shape s1 = new Circle(5);
Shape s2 = new Rectangle(4, 6);

System.out.println(s1.area());
System.out.println(s2.area());
```

Why This Design Is Ideal?

- No if-else chains

- Open for extension

- Closed for modification

- Clean separation of concerns

## Activity

From the Payment System example:

Task:

1. Add a new payment method called:
   - OnlineBankPayment

   Rules:
   - Must implement PaymentMethod

   Must NOT modify:
   - PaymentMethod

   - PaymentProcessor

   - Must show at least two processing steps\
     ```
     Paid ₱2500 using Online Banking
     Redirecting to bank portal...
     Payment successful
     ```

2. Add Transaction Fees

   Requirement
   Some payment methods charge fees:

   ```
   Payment Method	Fee
   Cash	        0%
   Credit Card	    3%
   Online Bank	    1.5%
   ```

   Rules:
   - Fees must be calculated inside the payment method

   - PaymentProcessor must remain unchanged

   Display:
   - original amount

   - fee

   - total charged

   Expected output example:

   ```
   Original Amount: ₱1000
   Transaction Fee: ₱30
   Total Charged: ₱1030
   ```
