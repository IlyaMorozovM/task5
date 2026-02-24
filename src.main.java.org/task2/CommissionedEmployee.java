package task2;

public class CommissionedEmployee extends Employee {
    private final double commissionRate;
    private final double sales;
    public static double BONUS = 0.1;

    public CommissionedEmployee(String name, double commissionRate, double sales) {
        super(name);
        this.commissionRate = commissionRate;
        this.sales = sales;
    }

    @Override
    public Money calculatePay() {
        return new Money(sales * commissionRate);
    }

    @Override
    public Money calculateBonus() {
        return new Money(sales * BONUS);
    }
}

