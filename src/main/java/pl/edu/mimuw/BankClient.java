package pl.edu.mimuw;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BankClient {

  private String name, surname;
  private int age;
  private String accountNumber;
  private List<BankAction> actionHistory;

  BankClient(String name, String surname, int age, String accountNumber) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.accountNumber = accountNumber;
    this.actionHistory = new ArrayList<>();
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
    return new ArrayList<>(actionHistory);
  }

  public void addAction(BankAction action) {
    actionHistory.add(action);
  }

  public double getBalanceAtMoment(Timestamp moment) {
    double balance = 0;
    for (var action : actionHistory) {
      if (moment.before(action.getStartTimestamp()) ||
          moment.after(action.getEndTimestamp()))
        continue;
      balance += action.totalAmount();
    }
    return balance;
  }

  @Override
  public String toString() {
    var builder = new StringBuilder("BankClient " +
        name + ", " + surname + ", " + age + ", " + accountNumber + "\n");
    for (var action : actionHistory)
      builder.append("  ").append(action.toString()).append("\n");
    return builder.toString();
  }
}
