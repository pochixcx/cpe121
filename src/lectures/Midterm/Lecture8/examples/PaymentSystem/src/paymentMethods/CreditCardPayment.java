package lectures.Midterm.Lecture8.examples.PaymentSystem.src.paymentMethods;

import lectures.Midterm.Lecture8.examples.PaymentSystem.src.interfaces.PaymentMethod;

public class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₱" + amount + " using Credit Card");
        System.out.println("Validating card details...");
        System.out.println("Transaction approved");
    }
}