package task3;

public class PaymentProcessor {
    public void makePayment(PaymentMethod payment, double amount) {
        if (payment.validatePaymentDetails()) {
            payment.processPayment(amount);
        } else {
            System.out.println("Payment details are invalid. Payment not processed.");
        }
    }
}
