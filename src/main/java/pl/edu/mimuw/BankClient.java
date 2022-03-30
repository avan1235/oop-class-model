package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class BankClient {
  private final String name, surname;
  private final int age;
  private final String accountNumber;
  private final ArrayList<BankAction> actionHistory;

  public BankClient(String name, String surname, int age, String accountNumber) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.accountNumber = accountNumber;
    this.actionHistory = new ArrayList<>();
  }
  public BankClient(BankClient action) {
    this.name = action.getName();
    this.surname = action.getSurname();
    this.age = action.getAge();
    this.accountNumber = action.getAccountNumber();
    this.actionHistory = new ArrayList<>(action.getActionHistory());
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getAge() {
    return age;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public List<BankAction> getActionHistory() {
    return actionHistory;
  }

  public void addAction(BankAction action) {
    actionHistory.add(action);
  }

  public void clearHistory(){
    actionHistory.clear();
  }

  public String toString(){
    return "Client " + name + " " + surname + ", " + age + " years old, account number: " +
            accountNumber + " actions history:" + actionHistory.toString();
  }
}
