package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank(1233503, new ArrayList<BankClient>());

    bank.addClient(new BankClient("Szymon", "Krawczak", 19, "10000", 1000000, new ArrayList<BankAction>()));
    bank.addClient(new BankClient("Tomek", "Lyshevsky", 18, "40950", 2, new ArrayList<BankAction>()));
    bank.addClient(new BankClient("Jan", "Kowalski", 18, "25802", 13980, new ArrayList<BankAction>()));

    bank.getClient(2).addAction(new LoanBankAction(1000, new Timestamp(200), new Timestamp(400), 2, 780));
    bank.getClient(1).addAction(new LoanBankAction(2400, new Timestamp(700), new Timestamp(44400), 6, 9000));
    bank.getClient(1).addAction(new LoanBankAction(100, new Timestamp(300), new Timestamp(760), 3, 80));
    bank.getClient(0).addAction((new DepositBankAction(1780, new Timestamp(1000), new Timestamp(12500), 2, "Can't break")));
    bank.getClient(2).addAction((new DepositBankAction(2300, new Timestamp(1450), new Timestamp(6700), 3.5, "Can break")));

    System.out.println(bank.toString());
  }
}
