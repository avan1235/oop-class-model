package pl.edu.mimuw;

import java.sql.Timestamp;

public class Main {

  public static void main(String[] args) {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank("Artur", "MIMUW Bank");

    var loanClient = new BankClient("Jeff", "Bezos", 58);
    var depositClient = new BankClient("Artur", "Kamieniecki", 19);
    var mixedClient = new BankClient("Pawel", "Bozek", 20);

    bank.addClient(loanClient);
    bank.addClient(depositClient);
    bank.addClient(mixedClient);

    System.out.println(bank);
    var instantTimestamp = new Timestamp(System.currentTimeMillis());
    var laterTimestamp = new Timestamp(System.currentTimeMillis() + 100000);

    var deposit100 = new DepositBankAction(100, 0.2, instantTimestamp);
    var depositFraction = new DepositBankAction(55.13, 0.50, instantTimestamp);
    var depositNotEnding = new DepositBankAction(31333.33, 10, laterTimestamp);

    var loan100 = new LoanBankAction(100, 0.2, laterTimestamp, 100);
    var loanFraction = new LoanBankAction(13, 5, laterTimestamp, 3);
    var loanPenalty = new LoanBankAction(1, 0, instantTimestamp, 50000);

    loanClient.addAction(loan100);
    loanClient.addAction(loanPenalty);

    depositClient.addAction(deposit100);
    depositClient.addAction(depositFraction);
    depositClient.addAction(depositNotEnding);

    mixedClient.addAction(depositNotEnding);
    mixedClient.addAction(loanPenalty);
    mixedClient.addAction(loanFraction);

    System.out.println(loanClient.getName());
    System.out.println(depositClient.getAge());
    System.out.println(mixedClient.getAccountNumber());

    System.out.println(loanClient.loansSum());
    System.out.println(loanClient.depositsSum());

    for (var action: loanClient.getActions()) {
      if (action instanceof LoanBankAction) {
        ((LoanBankAction) action).pay(((LoanBankAction) action).toPay());
      }
    }

    System.out.println(loanClient.loansSum());

    System.out.println(depositClient.loansSum());
    System.out.println(depositClient.depositsSum());

    for (var action: depositClient.getActions()) {
      if (action instanceof DepositBankAction) {
        ((DepositBankAction) action).withdrawal();
      }
    }

    System.out.println(depositClient.depositsSum());
  }
}
