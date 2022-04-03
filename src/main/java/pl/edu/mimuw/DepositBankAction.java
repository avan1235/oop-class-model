package pl.edu.mimuw;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class DepositBankAction extends BankAction {
    private final double interestRate;
    private final double capitalizationRate;
    private boolean collected = false;

    public DepositBankAction(double initial, Timestamp start,
                             Timestamp end, String id, double interestRate,
                             double capitalizationRate) {
        super(initial, start, end, id);
        this.interestRate = interestRate;
        this.capitalizationRate = capitalizationRate;
    }

    public boolean isEligible(BankClient client) {
        return client.getBalance() >= initialAmount;
    }

    public void execute(Bank bank, BankClient client) {
        if (client.getBalance() < initialAmount)
            throw new IllegalArgumentException("Deposit failed! " + client.getCredentials()
                    + " is too poor to deposit " + initialAmount + ".");
        else {
            client.subtractBalance(initialAmount);
            client.addAction(this);
        }
    }

    public void collect(Bank bank, BankClient client) {
        if (!collected && bank.getCurrentDate().after(endDate)) {
            client.addBalance(totalAmount());
            this.collected = true;
        }
    }

    // Deposit period in days.
    private long getDepositPeriod() {
        return TimeUnit.MILLISECONDS.toDays(endDate.getTime() - startDate.getTime());
    }

    public double getProfit() {
        return Math.round(initialAmount * (1 + interestRate / capitalizationRate)
                * capitalizationRate * getDepositPeriod() / 365);
    }

    // Returns total amount including profit from deposition, if there was any.
    public double totalAmount() {
        return initialAmount + getProfit();
    }

    public String toString() {
        String result = getID() + ": deposited " + initialAmount +
                " for " + getDepositPeriod() + " days. On date " +
                endDate + " will collect " + totalAmount();

        return result;
    }
}
