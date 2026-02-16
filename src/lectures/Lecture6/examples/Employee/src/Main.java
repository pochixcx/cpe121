package lectures.Lecture6.examples.Employee.src;

import lectures.Lecture6.examples.Employee.src.model.Employee;

public class Main {

    public static void main(String[] args) {
        // create employees
        Employee emp1 = new Employee(1, "Joseph", 30000);
        Employee emp2 = new Employee(2, "Rigor", 40000);

        System.out.println(emp1.toString());
        System.out.println(emp2.toString());

        // instead of directly accessing the objet fields, we interact
        // with the object via it's exposed methods
        emp1.raiseSalary(5.0);
        emp2.setSalary(55000.00);

        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
    }

}
