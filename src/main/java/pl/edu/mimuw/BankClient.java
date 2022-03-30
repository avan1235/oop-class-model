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
    this.actionHistory = new ArrayList<BankAction>();
  }

  // TODO:
  // - create proper constructor
  // - implement methods
  // - add your own methods (1 is enough)

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

  public void updateFunds(Double amount){
    this.availableFunds += amount;
  }

  public void addAction(BankAction action) {
    this.actionHistory.add(action);
  }
}
