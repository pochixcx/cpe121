package lectures.Lecture8.examples.PaymentSystem.src.service;

import lectures.Lecture8.examples.PaymentSystem.src.interfaces.PaymentMethod;

public class PaymentService {
    public void processPayment(PaymentMethod paymentMethod, double amount) {
        System.out.println("Processing payment...");
        paymentMethod.pay(amount);
        System.out.println("Payment completed\n");
    }
}
