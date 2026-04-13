package lectures.Midterm.Lecture8.examples.PaymentSystem.src.paymentMethods;

import lectures.Midterm.Lecture8.examples.PaymentSystem.src.interfaces.PaymentMethod;

public class CashPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₱" + amount + " in cash");
        System.out.println("Please collect the cash from the customer");
    }
}