package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class BankClient {

  private final String name;
  private final String surname;
  private int age;
  private int money;
  private final String accountNumber;
  private List<BankAction> actions;

  public BankClient(String name, String surname, int age, int money, String accountNumber, List<BankAction> actions) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.money = money;
    this.accountNumber = accountNumber;
    this.actions = actions;
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public int getAge() {

    return age;
  }

  public int getMoney() {
    return this.money;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public List<BankAction> getActionHistory() {
    var result = new ArrayList<BankAction>();
    for (var singleAction : this.actions) {
      result.add(singleAction);
    }
    return result;
  }

  public int getActionNumber() {
    return this.actions.size();
  }

  public void addAction(BankAction action) {
    var result = this.actions;
    result.add(action);
    this.actions = result;
  }


  public boolean isRich() {
    if (this.money > 1000000) {
      return true;
    } else {
      return false;
    }
  }

  public void giveMoney(int cash) {
    this.money += cash;
  }

  public void takeMoney(int cash) {
    this.money -= cash;
  }

  public void getOlder() {
    this.age++;
  }

}
