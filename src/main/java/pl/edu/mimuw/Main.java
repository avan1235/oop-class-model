package pl.edu.mimuw;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank();


    var client1 = new BankClient("Piotr", "Guzik", 19, "1", new ArrayList<BankAction>());
    bank.addClient(client1);

    var client2 = new BankClient("Joanna", "Fastryga", 67, "2", new ArrayList<BankAction>());
    bank.addClient(client2);

    var client3 = new BankClient("Maria", "Ścieg", 31, "3", new ArrayList<BankAction>());
    bank.addClient(client3);

    var loan1 = new LoanBankAction(3.4, 50.0, 50000.0, new Timestamp(55478911), new Timestamp(55478974));
    var loan2 = new LoanBankAction(0.2, 0.0, 2137.69, new Timestamp(4895850), new Timestamp(37474785));
    var deposit1 = new DepositBankAction("023", 420.69, new Timestamp(489556789), new Timestamp(489556850));


    bank.getClient(1).addAction(loan2);
    bank.getClient(2).addAction(deposit1);
    bank.getClient(0).addAction(loan1);

    
    System.out.println(bank.toString());
  }
}
