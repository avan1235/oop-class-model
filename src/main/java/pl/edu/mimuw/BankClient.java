package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BankClient {

  private final String name;

  private final String surname;

  private final int age;

  private final String accountNumber;

  private final List<BankAction> actionHistory;

  // I've decided to add similar fields here as in the Bank class to reduce number of counting these fields.
  private double moneyDeposited;

  private double moneyLoaned;

  public BankClient(String name, String surname, int age, String accountNumber, List<BankAction> actionHistory,
                    double moneyDeposited, double moneyLoaned) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.accountNumber = accountNumber;
    this.actionHistory = new ArrayList<>(actionHistory);
    this.moneyDeposited = moneyDeposited;
    this.moneyLoaned = moneyLoaned;
  }

  public BankClient(String name, String surname, int age, String accountNumber, List<BankAction> actionHistory) {
    this(name, surname, age, accountNumber, actionHistory, 0, 0);
  }

  public BankClient(BankClient other) {
    this(other.name, other.surname, other.age, other.accountNumber, other.actionHistory, other.moneyDeposited,
      other.moneyLoaned);
  }

  public BankClient(String name, String surname, int age, String accountNumber) {
    this(name, surname, age, accountNumber, new ArrayList<BankAction>());
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
    return new ArrayList<BankAction>(this.actionHistory);
  }

  /**
   * @return total amount of money deposited by the client.
   */
  public double getMoneyDeposited() {
    return this.moneyDeposited;
  }

  /**
   * @return total amount of money loaned by the client.
   */
  public double getMoneyLoaned() {
    return this.moneyLoaned;
  }

  /**
   * Adds money to the total value of money deposited by the client.
   *
   * @param money amount of money to be added.
   */
  public void addMoneyDeposited(double money) {
    this.moneyDeposited += money;
  }

  /**
   * Adds money to the total value of money loaned by the client.
   *
   * @param money amount of money to be added.
   */
  public void addMoneyLoaned(double money) {
    this.moneyLoaned += money;
  }

  public void addAction(BankAction action) {
    this.actionHistory.add(action);
  }

  /**
   * @return string representation of the client with their actions sorted by start date.
   */
  @Override
  public String toString() {
    final var sb = new StringBuilder();

    sb.append("Client: ").append(this.name).append(" ").append(this.surname).append(", age: ").append(this.age)
      .append(", account number: ").append(this.accountNumber).append("\n").append("\tAccount history:\n");

    this.getActionHistory().stream()
      .sorted(Comparator.comparing(BankAction::getStartTimestamp))
      .forEach(action -> sb.append("\t\t").append(action).append("\n"));

    return sb.toString();
  }
}
