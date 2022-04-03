package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final Bank bank = new Bank("MIM UW");

    BankClient client = new BankClient("Grzegorz", "Brzęczyszczykiewicz", 19, "12345");
    DepositBankAction deposit = new DepositBankAction(70.0, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()), 0.17, 100.0);
    client.addAction(deposit);
    System.out.println(client.getName());
    bank.addClient(client);
    System.out.println(bank);
  }
}
