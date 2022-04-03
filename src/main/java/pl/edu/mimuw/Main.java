package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank("Pocztowy Ranczo", "Poland");

    BankClient ja = new BankClient("Florian", "Ficek", "Wadowice", 20);
    BankClient MW = new BankClient("Marcin", "Wadowita", "Wadowice", 453);
    BankClient PB = new BankClient("Paweł", "Brożek", "Kraków", 38);

    bank.addClient(ja);
    bank.addClient(MW);
    bank.addClient(PB);

    ja.depositMoney(50000);
    MW.depositMoney(19600);
    PB.depositMoney(13000);

    var loan = new LoanBankAction(10000, new Timestamp(1), new Timestamp(100), 5);
    ja.addAction(loan);

    var loan2 = new LoanBankAction(2137, new Timestamp(5), new Timestamp(150), 7);
    ja.addAction(loan2);

    ja.withdrawMoney(40000);
    MW.withdrawMoney(20000);
    PB.withdrawMoney(500);

    var deposit = new DepositBankAction(1000, new Timestamp(500), new Timestamp(2137213721), 5, 2137);
    MW.addAction(deposit);

    var deposit2 = new DepositBankAction(500, new Timestamp(0), new Timestamp(31820983), 10, 4204.20);
    PB.addAction(deposit2);

    System.out.println(bank);
  }
}
