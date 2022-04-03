package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank();

    var moravyetski = new BankClient("Mateusz", "Morawiecki", 53, "696969");
    bank.addClient(moravyetski);
    moravyetski.addAction(new LoanBankAction(1000, new Timestamp(1000), new Timestamp(2000), "WAW107", 7000));
    moravyetski.addAction(new DepositBankAction(20, new Timestamp(1500), new Timestamp(9999), "WAW107"));

    var rand = ThreadLocalRandom.current();
    for (var i = 0; i < 10; ++i) {
      var client_i = new BankClient("Tomasz", "ProblemNr" + i, i + 18, String.valueOf(i + 100000));
      bank.addClient(client_i);

      var n_actions = (i == 0 ? 20 : rand.nextInt(1, 10));
      for (var j = 0; j < n_actions; ++j) {
        if (rand.nextBoolean()) {
          client_i.addAction(new LoanBankAction(rand.nextInt(1, 2000), new Timestamp(rand.nextInt(1000, 5000)),
              new Timestamp(rand.nextInt(5000, 10000)), "WAWBOT", rand.nextInt(0, 100)));
        } else {
          client_i.addAction(new DepositBankAction(rand.nextInt(1, 2000), new Timestamp(rand.nextInt(1000, 5000)),
              new Timestamp(rand.nextInt(5000, 10000)), "WAWBOT"));
        }
      }
    }
    System.out.println(bank);

    for (var i = 100; i < 10000; i += 400) {
      var t = new Timestamp(i);
      System.out.println(t.toString() + ": " + bank.getAllClients().get(1).getBalanceAtMoment(t));
    }
  }
}
