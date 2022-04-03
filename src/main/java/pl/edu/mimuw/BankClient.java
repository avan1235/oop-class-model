package pl.edu.mimuw;

import java.util.List;

public class BankClient {
  private final String name;
  private final  String surname;
  private int age;
  private final String accountNumber;
  private List<BankAction> actionHistory;


  public BankClient(String name, String surname, int age, String accountNumber, List<BankAction> actionHistory) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.accountNumber = accountNumber;
    this.actionHistory = actionHistory;
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

  public double calculateCreditScore() {
    double creditScore = 0;
    int numberOfActions = 0;

    double allFunds = 0;
    for (BankAction act: this.actionHistory) {
      allFunds += act.getTotalAmount();
      numberOfActions++;
    }

    creditScore = allFunds / numberOfActions;

    return creditScore;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
      sb.append("\n").append("Name: ").append(this.name).append("\n");
      sb.append("Surname: ").append(this.surname).append("\n");
      sb.append("Age: ").append(this.age).append("\n");
      sb.append("Account number: ").append(this.accountNumber).append("\n");
      sb.append("Action history:\n").append(this.actionHistory);
    return sb.toString();
  }
  
}
