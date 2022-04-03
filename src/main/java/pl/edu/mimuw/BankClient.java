package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;


public class BankClient {
  private final String name, surname;
  private final String accountNumber;
  private final int age;
  private final List<BankAction> actionHistory;

  public BankClient(BankClient client) {
    this.name = client.name;
    this.surname = client.surname;
    this.age = client.age;
    this.accountNumber = client.accountNumber;
    this.actionHistory = new ArrayList<>();

    for (BankAction ba : client.actionHistory) {
      this.actionHistory.add(ba.getCopy());
    }
  }

  public BankClient(String name, String surname, int age, String accountNumber) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.accountNumber = accountNumber;
    this.actionHistory = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public int getAge() {
    return this.age;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public List<BankAction> getActionHistory() {
    List<BankAction> l = new ArrayList<>();

    for (BankAction ba : this.actionHistory) {
      l.add(ba.getCopy());
    }

    return l;
  }

  public double getDepositsAmount() {
    double sum = 0;
    for (BankAction ba : this.actionHistory) {
      if (ba instanceof DepositBankAction) {
        sum += ba.getTotalAmount();
      }
    }

    return sum;
  }

  public double getLoansAmount() {
    double sum = 0;
    for (BankAction ba : this.actionHistory) {
      if (ba instanceof LoanBankAction) {
        sum += ba.getTotalAmount();
      }
    }

    return sum;
  }

  public BankClient getCopy() {
    return new BankClient(this);
  }

  public String toString() {
    var sb = new StringBuilder();
    sb.append("Client " + this.name + " " + this.surname + ", age " + this.age + ", ");
    sb.append("account number: " + this.accountNumber + "\n");
    sb.append("Bank actions: ");

    for (BankAction ba : this.actionHistory) {
      sb.append(ba.toString() + "\n");
    }

    return sb.toString();
  }

  public void addAction(BankAction action) {
    this.actionHistory.add(action);
  }
}
