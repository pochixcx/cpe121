package lectures.Lecture8.examples.PaymentSystem.src.paymentMethods;

import lectures.Lecture8.examples.PaymentSystem.src.interfaces.PaymentMethod;

public class GCashPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₱" + amount + " using GCash");
        System.out.println("Sending OTP...");
        System.out.println("Payment successful");
    }
}