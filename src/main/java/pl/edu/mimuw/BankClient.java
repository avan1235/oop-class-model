package pl.edu.mimuw;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

  public void setAge(int age) {
    this.age = age;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public List<BankAction> getActionHistory() {
    return new ArrayList<>(actionHistory);
  }

  public void addAction(BankAction action) {
    actionHistory.add(action);
  }

  public double getBalanceAtMoment(Timestamp moment) {
    return actionHistory.stream()
        .filter(action -> !(moment.before(action.getStartTimestamp()) ||
            moment.after(action.getEndTimestamp())))
        .map(action -> action.totalAmount())
        .collect(Collectors.summingDouble(Double::valueOf));
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
