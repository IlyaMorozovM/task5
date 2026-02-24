package task3;

class PayPalPayment extends PaymentMethod {
    private final boolean isBankLinked;

    public PayPalPayment(boolean isBankLinked) {
        this.isBankLinked = isBankLinked;
    }

    @Override
    boolean validatePaymentDetails() {
        return isBankLinked;
    }

    @Override
    void processPayment(double amount) {
        System.out.println("PayPal payment processed: " + amount);
    }
}
