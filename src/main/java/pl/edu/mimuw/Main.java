package pl.edu.mimuw;

import java.io.IOException;

import java.sql.Timestamp;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank("MIM UW", "Warsaw");

    var client1 = new BankClient("Mateusz", "Scharmach", 19, "0001");
    bank.addClient(client1);
    client1.addAction(new LoanBankAction(5000, Timestamp.valueOf("2022-04-03 00:00:00"), Timestamp.valueOf("2023-12-01 00:00:00"), "Student loan", 300));
    client1.addAction(new DepositBankAction(5000, Timestamp.valueOf("2022-04-03 00:00:00"), Timestamp.valueOf("2023-12-01 00:00:00"), 0.05, 0.005));
    System.out.print(client1.getName());
    System.out.print(" ");
    System.out.print(client1.getSurname());
    System.out.print(" lost ");
    System.out.println(-client1.overallIncome());
    System.out.println();

    var client2 = new BankClient("Paweł", "Strzelecki", 59, "0002");
    bank.addClient(client2);

    var dziekanLoan = new LoanBankAction(10000, Timestamp.valueOf("2022-02-01 00:00:00"), Timestamp.valueOf("2022-05-01 00:00:00"), "lift renovation", 2000);
    client2.addAction(dziekanLoan);
    System.out.print(client2.getName());
    System.out.print(" ");
    System.out.println(client2.getSurname());
    System.out.println(dziekanLoan);

    var client3 = new BankClient("Piotr", "Nayar", 35, "0003");
    bank.addClient(client3);
    client3.addAction(new DepositBankAction(30000, Timestamp.valueOf("2022-05-15 00:00:00"), Timestamp.valueOf("2026-06-01 00:00:00"), 0.03, 0.007));
    System.out.println(bank);
  }
}
