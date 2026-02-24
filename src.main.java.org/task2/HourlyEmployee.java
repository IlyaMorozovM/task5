package task2;

public class HourlyEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;
    public static int FIXED_BONUS = 100;

    public HourlyEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public Money calculatePay() {
        return new Money(hourlyRate * hoursWorked);
    }

    @Override
    public Money calculateBonus() {
        return new Money(FIXED_BONUS);
    }
}
