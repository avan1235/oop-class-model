package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.stream.Stream;

public class Main {
  private static Stream<BankAction> actionsGenerator() {
    Stream.Builder<pl.edu.mimuw.BankAction> builder = Stream.builder();

    // Adding elements in the stream of Strings
    return builder.add(new DepositBankAction(100, Timestamp.valueOf("2022-03-01 12:00:00"), Timestamp.valueOf("2022-03-30 12:00:00"), 10))
      .add(new DepositBankAction(200, Timestamp.valueOf("2022-04-01 12:00:00"), Timestamp.valueOf("2022-04-30 12:00:00"), 20))
      .add(new DepositBankAction(300, Timestamp.valueOf("2022-04-01 12:00:00"), Timestamp.valueOf("2022-04-30 12:00:00"), 30))
      .build();
  }
  public static void main(String[] args) {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank();

    BankClient jk = new BankClient("Jakub", "Klimek", 20, bank.newAccountNumber());
    bank.addClient(jk);
    BankClient mp = new BankClient("Maciej", "Procyk", 23, bank.newAccountNumber());
    bank.addClient(mp);

    jk.addAction(new LoanBankAction(5000, Timestamp.valueOf("2021-10-15 12:00:00"), Timestamp.valueOf("2022-10-15 12:00:00"), 5));

    for(var ac : actionsGenerator().toList()) {
      mp.addAction(ac);
    }
    System.out.println(bank);
  }
}
