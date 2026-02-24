package task1.strategy;

public class DefaultFineStrategy implements FineStrategy {
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays > 0 ? overdueDays * 1.0 : 0.0;
    }
}
