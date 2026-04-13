package lectures.Midterm.Lecture8.examples.PaymentSystem.src;

import lectures.Midterm.Lecture8.examples.PaymentSystem.src.paymentMethods.CashPayment;
import lectures.Midterm.Lecture8.examples.PaymentSystem.src.paymentMethods.CreditCardPayment;
import lectures.Midterm.Lecture8.examples.PaymentSystem.src.paymentMethods.GCashPayment;
import lectures.Midterm.Lecture8.examples.PaymentSystem.src.service.PaymentService;

public class Main {
    public static void main(String[] args) {

        PaymentService service = new PaymentService();

        service.processPayment(new CashPayment(), 300);
        service.processPayment(new CreditCardPayment(), 2000);
        service.processPayment(new GCashPayment(), 1200);
    }
}