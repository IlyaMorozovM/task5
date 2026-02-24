package task3;

class CreditCardPayment extends PaymentMethod {
    @Override
    boolean validatePaymentDetails() {
        return true;
    }

    @Override
    void processPayment(double amount) {
        System.out.println("Credit card payment processed: " + amount);
    }
}
