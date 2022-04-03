package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction {

    protected final double initialAmount;
    protected final Timestamp startDate;
    protected final Timestamp endDate;
    private final String id;

    protected BankAction(double initialAmount, Timestamp startDate,
                         Timestamp endDate, String id) {
        this.initialAmount = initialAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
    }

    public abstract boolean isEligible(BankClient client);

    public abstract void execute(Bank bank, BankClient client);

    public abstract void collect(Bank bank, BankClient client);

    public String getID() {
        return this.id;
    }

    public double getInitialAmount() {
        return this.initialAmount;
    }

    public Timestamp getStartDate() {
        return (Timestamp) this.startDate.clone();
    }

    public Timestamp getEndDate() {
        return (Timestamp) this.endDate.clone();
    }

    @Override
    public abstract String toString();
}
