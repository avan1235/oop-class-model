package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank();

    bank.addClient(new BankClient("Arnold", "Schwarzenegger", 74, "001"));

    LocalDateTime today = LocalDateTime.now();
    LocalDateTime yearFromToday = today.withYear(2023);

    bank.getClient(0).addAction(new DepositBankAction(10_000,
      Timestamp.valueOf(today),
      Timestamp.valueOf(yearFromToday),
      0.05));
    bank.getClient(0).addAction(new LoanBankAction(5_000,
      Timestamp.valueOf(today),
      Timestamp.valueOf(yearFromToday),
      true));

    bank.addClient(new BankClient("James", "Bond", 30, "007"));

    bank.getClient(1).addAction(new DepositBankAction(25_000,
      Timestamp.valueOf(today),
      Timestamp.valueOf(yearFromToday),
      0.2));
    bank.getClient(1).addAction(new LoanBankAction(17_000,
      Timestamp.valueOf(today),
      Timestamp.valueOf(yearFromToday),
      false));

    System.out.println(bank);

  }
}
