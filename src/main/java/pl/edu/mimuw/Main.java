package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank();

    List emptyList = new ArrayList<BankAction>();
    BankClient rafal = new BankClient("Rafal", "Brzozowski", 41, 5000000, "1234567", new ArrayList<BankAction>());
    bank.addClient(rafal);
    rafal.getOlder();
    var sb = new StringBuilder();
    sb.append(rafal.getName()).append(" ").append(rafal.getSurname()).append(" age is ");
    sb.append(rafal.getAge()).append("\n");
    System.out.print(sb.toString());
    var actions1 = new LoanBankAction(100, 1, new Timestamp(0), new Timestamp(10));
    rafal.addAction(actions1);
    var actions2 = new DepositBankAction(10000, new Timestamp(100), new Timestamp(1000));
    rafal.addAction(actions2);
    System.out.println(actions2);

    BankClient whoever = new BankClient("Who Even", "Cares", 99, 500, "127444324", new ArrayList<BankAction>());
    bank.addClient(whoever);
    var actions3 = new LoanBankAction(1000000, 10, new Timestamp(0), new Timestamp(10));
    if (whoever.isRich()) {
      System.out.println("Whoever it is, They are rich\n");
    } else {
      System.out.println("Whoever it is, They are poor\n");
    }
    whoever.addAction(actions3);


    System.out.println(bank);
  }
}
