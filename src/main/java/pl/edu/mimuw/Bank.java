package pl.edu.mimuw;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class Bank {

    private final ArrayList<BankClient> allClients = new ArrayList<>();
    private final double depositInterestRate;
    private final double loanInterestRate;
    private Timestamp today = Timestamp.valueOf(java.time.LocalDateTime.now());
    private int clientCount = 1;
    private int actionCount = 1;

    public Bank(double depositInterestRate, double loanInterestRate) {
        this.depositInterestRate = depositInterestRate;
        this.loanInterestRate = loanInterestRate;
    }

    private String assignActionNumber() {
        return String.format("%04d", actionCount++);
    }

    private String assignClientNumber() {
        return String.format("%04d", clientCount++);
    }

    public void collectInstallments() {
        for (var client : allClients)
            for (var action : client.getActionHistory())
                action.collect(this, client);
    }

    public void advanceCurrentDate(int days) {
        Calendar date = Calendar.getInstance();

        date.setTime(this.today);
        date.add(Calendar.DATE, days);

        this.today = Timestamp.from(date.toInstant());
    }

    public Timestamp getCurrentDate() {
        return this.today;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("BANK STATS\nList of clients:\n");

        for (var client : allClients) {
            result.append(client.getCredentials()).
                    append(" acc bal: ").append(client.getBalance())
                    .append(", number " + "of actions: ")
                    .append(client.getActionHistory().size()).append("\n");
            for (var action : client.getActionHistory())
                result.append(" * ").append(action.toString()).append("\n");
        }

        result.append("Interest rates: \nDeposit: ")
                .append(this.depositInterestRate)
                .append(", loan: ")
                .append(this.loanInterestRate).append("\n");

        result.append("In total: \nAccounts: ").append(this.clientCount - 1)
                .append(", actions: ").append(this.actionCount - 1);

        return result.toString();
    }

    public ArrayList<BankClient> getAllClients() {
        return (ArrayList<BankClient>) allClients.clone();
    }

    public BankClient openClientAccount(String name, String surname, int age,
                                        double balance) {
        final var id = "MIM" + assignClientNumber();

        BankClient client = new BankClient(name, surname, age, id, balance);

        allClients.add(client);

        return client;
    }

    public void applyForDeposit(BankClient applicant, double amountToDeposit,
                                Timestamp toDate, double capitalizationRate) {

        final var id = "DEP" + assignActionNumber();

        DepositBankAction deposit = new DepositBankAction(amountToDeposit,
                today, toDate, id, depositInterestRate, capitalizationRate);

        if (deposit.isEligible(applicant)) deposit.execute(this, applicant);
        else
            throw new IllegalArgumentException("Deposit refused: "
                    + applicant.getId() + " is too poor.");

    }

    public void applyForLoan(BankClient applicant, double amountToLoan,
                             Timestamp toDate) {

        final var id = "LOA" + assignActionNumber();

        LoanBankAction loan = new LoanBankAction(amountToLoan, today, toDate,
                id, loanInterestRate);

        if (loan.isEligible(applicant)) loan.execute(this, applicant);
        else
            throw new IllegalArgumentException("Loan refused: "
                    + applicant.getCredentials() + " is too poor.");

    }

    public BankClient getClientByID(String clientID) {
        final var clients = getAllClients();

        for (BankClient client : clients)
            if (client.getId().equals(clientID)) return client;

        throw new IllegalArgumentException("Invalid client ID.");
    }

    public BankClient getClientByIndex(int clientIndex) {
        final var clients = getAllClients();

        if (clientIndex >= clients.size())
            throw new IllegalArgumentException("Invalid client index");
        return clients.get(clientIndex);
    }
}
