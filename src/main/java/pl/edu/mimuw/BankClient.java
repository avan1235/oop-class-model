package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankClient {

  private final String firstName;
  private final String lastName;
  private final int age;
  private final String accountNumber;
  private final List<BankAction> actions;

  public BankClient(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;

    var sb = new StringBuilder();
    var randomGenerator = new Random();
    for (int i = 0; i < 10; i++) {
      sb.append(randomGenerator.nextInt(10));
    }
    this.accountNumber = sb.toString();

    this.actions = new ArrayList<BankAction>();
  }

  public BankClient(BankClient client) {
    this.firstName = client.firstName;
    this.lastName = client.lastName;
    this.age = client.age;
    this.accountNumber = client.accountNumber;
    this.actions = client.actions;
  }

  public String getName() {
    return this.firstName + " " + this.lastName;
  }

  public String getSurname() {
    return this.lastName;
  }

  public int getAge() {
    return this.age;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public void addAction(BankAction action) {
    this.actions.add(action);
  }

  public List<BankAction> getActionHistory() {
    final var newActions = new ArrayList<BankAction>();

    for (var action: this.actions) {
      newActions.add(action.copy());
    }

    return newActions;
  }

  public List<BankAction> getActions() {
    return this.actions;
  }

  protected double sumActions(Class<?> cls) {
    double sum = 0;

    for (var deposit: this.actions) {
      if (deposit.getClass() == cls) {
        sum += deposit.totalAmount();
      }
    }

    return sum;
  }

  public double depositsSum() {
    return this.sumActions(DepositBankAction.class);
  }

  public double loansSum() {
    return this.sumActions(LoanBankAction.class);
  }

  public BankClient copy() {
    return new BankClient(this);
  }

}
