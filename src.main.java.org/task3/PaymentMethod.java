package task3;

public abstract class PaymentMethod {
    abstract boolean validatePaymentDetails();
    abstract void processPayment(double amount);
}
