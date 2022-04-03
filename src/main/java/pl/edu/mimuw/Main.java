package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank("MIM UW Bank");

    var client_a = new BankClient("a", "sa", 18, "098761234");
    final var lnAction = new LoanBankAction(100, 20.3, new Timestamp(0), new Timestamp(100000), new Timestamp(100));
    client_a.addAction(lnAction);
    var client_b = new BankClient("b", "sb", 54, "662345893");
    bank.addClient(client_a);
    bank.addClient(client_b);
    System.out.println(bank.getAllClients());
    System.out.println("======================");
    System.out.println(bank);
    System.out.println("======================");
    final var exAction = new DepositBankAction(200, 2.3, new Timestamp(10), new Timestamp(1000));
    final var lnAction2 = new LoanBankAction(1000, 25, new Timestamp(100000), new Timestamp(400000), new Timestamp(200));
    var client_c = new BankClient("c", "sc", 31, "00123897");
    client_c.addAction(lnAction);
    client_c.addAction(exAction);
    client_c.addAction(lnAction2);
    bank.addClient(client_c);
    System.out.println(bank.getClient(2).toString());
  }
}
