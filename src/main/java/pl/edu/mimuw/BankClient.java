package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class BankClient {

  private final String name;
  private final String surname;
  private final int age;
  private final String city;
  private final String accountNumber;
  private double balance;
  private final List<BankAction> actionHistory;

  public BankClient(String name, String surname, String city, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.city = city;
    int code = (int) (Math.random()*8999 + 1000);
    this.accountNumber = "88 1010 5226 " + code;
    this.balance = 0;
    this.actionHistory = new ArrayList<BankAction>();
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

  public String getCity(){
    return this.city;
  }

  public double getBalance(){
    return this.balance;
  }

  public List<BankAction> getActionHistory() {
    return this.actionHistory;
  }

  public void addAction(BankAction action) {
    this.actionHistory.add(action);
  }

  public void depositMoney (double deposit){
    this.balance += deposit;
  }

  public void withdrawMoney (double withdraw){
    if(withdraw <= this.balance) {
      this.balance -= withdraw;
    }
  }

}
