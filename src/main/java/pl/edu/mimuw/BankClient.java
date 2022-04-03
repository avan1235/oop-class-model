package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class BankClient {
  private final String name;
  private final String surname;
  private final int age;
  private final String accountNumber;
  private double availableFunds;
  private final List<BankAction> actionHistory;

  public BankClient(String name, String surname, int age, String accountNumber) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.accountNumber = accountNumber;
    this.availableFunds = 0;
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

  public double getAvailableFunds() {
    return this.availableFunds;
  }

  public List<BankAction> getActionHistory() {
    return this.actionHistory;
  }

  public void updateFunds(Double amount) {
    this.availableFunds += amount;
  }

  public void addAction(BankAction action) {
    this.actionHistory.add(action);
  }

  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("name: ").append(this.name);
    stringBuilder.append(" \nsurname: ").append(this.surname);
    stringBuilder.append(", \nage: ").append(this.age);
    stringBuilder.append(", \naccountNumber: ").append(this.accountNumber);
    stringBuilder.append(", \navailableFunds: ").append(this.availableFunds);
    stringBuilder.append(", \nactionHistory: ").append(this.actionHistory);
    stringBuilder.append("}");

    return stringBuilder.toString();
  }
}
