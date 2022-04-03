package pl.edu.mimuw;

import java.sql.Timestamp;

public class Main {

  public static void main(String[] args) {
    System.out.println("Welcome in MIM UW Bank");
    var bank = new Bank("MIM UW BANK", "Zajmujemy się bankowością");
    var Krzysztof = new BankClient("Krzysztof", "Kubica", 21, "14121948");
    var Maciej = new BankClient("Maciej", "Maciejowski", 22, "84912141");
    var Mikołaj = new BankClient("Mikołaj", "Biegański", 21, "23091906");
    var jutro = new Timestamp(System.currentTimeMillis() + 86400000);
    var pojutrze = new Timestamp(System.currentTimeMillis() + 2*86400000);
    var superpozyczka = new LoanBankAction(1000, jutro, 0.05);
    var superpozyczka2 = new LoanBankAction(2000, jutro, 0.05);
    var ciekawaLokata = new DepositBankAction(1000, pojutrze, 0.02);
    //jakis maly pokaz metod - dodawanie akcji, splacanie dlugow, likwidacja depozytow przed i po dodaniu odpowiednich akcji
    bank.addClient(Krzysztof);
    bank.addClient(Maciej);
    bank.addActionForClient(superpozyczka.createCopy(), 1);
    bank.addActionForClient(superpozyczka.createCopy(), 0);
    bank.addActionForClient(superpozyczka2.createCopy(), 1);
    bank.addActionForClient(ciekawaLokata.createCopy(), 1);
    bank.addClient(Mikołaj);
    double resztaPoWplacie = bank.repaymentByClient(1500, 1);
    System.out.println("POZOSTAŁO: " + resztaPoWplacie);
    resztaPoWplacie = bank.repaymentByClient(1500, 0);
    System.out.println("POZOSTAŁO: " + resztaPoWplacie);
    double wyplata = bank.liquidationByClient(2);
    System.out.println("WYPLACONO: " + wyplata);
    bank.addActionForClient(ciekawaLokata.createCopy(), 2);
    wyplata = bank.liquidationByClient(2);
    System.out.println("WYPLACONO: " + wyplata);
    System.out.println(bank);
  }
}
