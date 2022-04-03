package pl.edu.mimuw;

import java.util.ArrayList;

public class BankClient {

  private final String name;
  private final String surname;
  private final int age;
  private final String accountNumber;
  private final ArrayList<BankAction> actionHistory;

  public BankClient(String name, String surname, int age, String accountNumber) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.accountNumber = accountNumber;
    this.actionHistory = new ArrayList<BankAction>();
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

  public ArrayList<BankAction> getActionHistory() {
    ArrayList<BankAction> copy = new ArrayList<>();
    copy.addAll(this.actionHistory);
    return copy;
  }

  public int overallIncome() {
    int tmp = 0;
    for (var v : actionHistory) {
      tmp += v.income();
    }
    return tmp;
  }

  public void addAction(BankAction action) {
    this.actionHistory.add(action);
  }
}
