package pl.edu.mimuw;

import java.util.List;

public class BankClient {

  private String name;
  private String surname;
  private int age;
  private String accountNumber;
  private List<BankAction> actionHistory;
  // TODO:
  // - create proper constructor
  // - implement methods
  // - add your own methods (1 is enough)

  public BankClient(String name, String surname, int age, String accountNumber) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.accountNumber = accountNumber;
    actionHistory = null;
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

  public BankClient createCopy() {
    return new BankClient(this.name, this.surname, this.age, this.accountNumber);
  }

  public void addAction(BankAction action) {
    throw new IllegalStateException("TODO");
  }
}
