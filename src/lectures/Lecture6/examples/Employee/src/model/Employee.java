package lectures.Lecture6.examples.Employee.src.model;

public class Employee {
    // Fields are private to protect data
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        setSalary(salary); // Use setter to validate
    }

    // Getter (accessor)
    public String getName() {
        return name;
    }

    // Setter (mutator) with validation
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary must be positive.");
        }
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Behavior method
    public void raiseSalary(double percent) {
        setSalary(this.salary + (this.salary * percent / 100));
    }

    public String toString() {
        return "Employee[ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }
}
