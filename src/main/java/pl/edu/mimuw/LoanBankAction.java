package pl.edu.mimuw;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class LoanBankAction extends BankAction {
    private final double interestRate;
    private final double monthlyDue;
    private Timestamp lastPayment;
    private int installments;

    public LoanBankAction(double initial, Timestamp start,
                          Timestamp end, String id, double interestRate) {
        super(initial, start, end, id);
        this.lastPayment = start;
        this.interestRate = interestRate;
        this.installments = (int) Math.max(getDepositPeriod() / 30, 1);
        final var q = 1 + interestRate / installments;
        final var x = Math.pow(q, installments);
        this.monthlyDue = Math.round(initial * x * (q - 1) / (x - 1));
    }

    public boolean isEligible(BankClient client) {
        return client.getBalance() >= monthlyDue;
    }

    public void execute(Bank bank, BankClient client) {
        client.addBalance(initialAmount);
        client.addAction(this);
    }

    public void collect(Bank bank, BankClient client) {
        final var currentDate = bank.getCurrentDate();

        if (installments > 0 && isPaymentDue(currentDate)) {
            payInstallment(client);
            lastPayment = currentDate;
        }
    }

    public void payInstallment(BankClient client) {
        client.subtractBalance(monthlyDue);
        installments--;
    }

    // Deposit period in days.
    private long getDepositPeriod() {
        return TimeUnit.MILLISECONDS.toDays(endDate.getTime() - startDate.getTime());
    }

    private boolean isPaymentDue(Timestamp currentDate) {
        return TimeUnit.MILLISECONDS.toDays(currentDate.getTime() - lastPayment.getTime()) > 30;
    }

    // Returns total amount including profit from deposition, if there was any.
    public double totalAmount() {
        return initialAmount + monthlyDue * installments;
    }

    public String toString() {
        String result = getID() + ": loaned " + initialAmount +
                ", installments to pay off: " + installments +
                ", due: " + endDate +
                ", monthly cost: " + monthlyDue;

        return result;
    }
}
