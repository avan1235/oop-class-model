package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank(123523503, new ArrayList<BankClient>());

    // TODO: play with bank:
    // - add new clients
    // - add different actions on clients accounts
    //    * try to do it with some bigger collections of actions (maybe even use streams)

    bank.addClient(new BankClient("Szymon", "Krawczak", 19, "10000", 1000000, new ArrayList<BankAction>()));
    bank.addClient(new BankClient("Tomek", "Lyshevsky", 18, "40950", 2, new ArrayList<BankAction>()));
    bank.addClient(new BankClient("Jan", "Kowalski", 18, "25802", 13980, new ArrayList<BankAction>()));

    bank.getClient(2).addAction(new LoanBankAction(1000, new Timestamp(200), new Timestamp(400), 2, 780));
    bank.getClient(1).addAction(new LoanBankAction(2400, new Timestamp(700), new Timestamp(44400), 6, 9000));
    bank.getClient(1).addAction(new LoanBankAction(100, new Timestamp(300), new Timestamp(760), 3, 80));

    System.out.println(bank.toString());
  }
}
