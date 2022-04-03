package pl.edu.mimuw;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class BankClient {

  private final String name;

  private final String surname;

  private final int age;

  private final String accountNumber;

  private final List<BankAction> actionHistory;

  public BankClient(String name, String surname, int age, String accountNumber, List<BankAction> actionHistory) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.accountNumber = accountNumber;
    this.actionHistory = new ArrayList<>(actionHistory);
  }

  public BankClient(BankClient other) {
    this(other.name, other.surname, other.age, other.accountNumber, other.actionHistory);
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
    return this.actionHistory;
  }

  public void addAction(BankAction action) {
    this.actionHistory.add(action);
  }

  /**
   * This method adds a couple of random actions to given client's action history.
   */
  public void addRandomActions() {
    final var numberOfActions = new Random().nextInt(7) + 1;

    for (int i = 0; i < numberOfActions; i++) {
      final var action = new Random().nextBoolean();
      final var amount = new Random().nextDouble() * 10000;
      final var startYear = new Random().nextInt(10) + 2010;
      final var startMonth = new Random().nextInt(12) + 1;
      final var startDay = new Random().nextInt(28) + 1;
      var endYear = startYear + new Random().nextInt(10);
      final var endMonth = (startMonth + new Random().nextInt(12)) % 12 + 1;
      if (endMonth <= startMonth && endYear == startYear) {
        endYear++;
      }
      final var endDay = (startDay + new Random().nextInt(28)) % 28 + 1;
      final var startDate = Timestamp.valueOf(LocalDateTime.of(startYear, Month.of(startMonth), startDay,
        0, 0, 0));
      final var endDate = Timestamp.valueOf(LocalDateTime.of(endYear, Month.of(endMonth), endDay,
        0, 0, 0));

      if (action) {
        final var percent = new Random().nextInt(5) + 1;
        this.addAction(new DepositBankAction(amount, startDate, endDate, percent));
      } else {
        final var rate = new Random().nextInt(10) + 5;
        this.addAction(new LoanBankAction(amount, startDate, endDate, rate));
      }
    }
  }

  /**
   * @return the sum of all deposits for given client.
   */
  public double getMoneyDeposited() {
    double result = 0;

    for (var action : this.actionHistory) {
      if (action instanceof DepositBankAction) {
        result += action.getAmount();
      }
    }

    return result;
  }

  /**
   * @return the sum of all loans for given client.
   */
  public double getMoneyLoaned() {
    double result = 0;

    for (var action : this.actionHistory) {
      if (action instanceof LoanBankAction) {
        result += action.getAmount();
      }
    }

    return result;
  }

  /**
   * @return string representation of the client with their actions sorted by start date.
   */
  @Override
  public String toString() {
    final var sb = new StringBuilder();

    sb.append("Client: ").append(this.name).append(" ").append(this.surname).append(", age: ").append(this.age)
      .append(", account number: ").append(this.accountNumber).append("\n").append("\tAccount history:\n");

    final var actionsList = new ArrayList<BankAction>(this.actionHistory);
    actionsList.stream()
      .sorted(Comparator.comparing(BankAction::getStartTimestamp))
      .forEach(action -> sb.append("\t\t").append(action).append("\n"));

    return sb.toString();
  }
}
