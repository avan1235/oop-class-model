package pl.edu.mimuw;

import java.util.List;
import java.util.ArrayList;

public class BankClient {
  private final String name;
  private final String surname;
  private int age;
  private String accountNumber;
  private double money;
  private List<BankAction> bankActions;
  // TODO:
  // - create proper constructor
  // - implement methods
  // - add your own methods (1 is enough)

  public BankClient(String name, String surname, int age, String accountNumber, double money, List<BankAction> bankActions)
  {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.accountNumber = accountNumber;
    this.money = money;
    this.bankActions = bankActions;
  }

  public String getName()
  {
    return this.name;
  }

  public String getSurname()
  {
    return this.surname;
  }

  public int getAge()
  {
    return this.age;
  }

  public String getAccountNumber()
  {
    return this.accountNumber;
  }

  public double getMoney()
  {
    return this.money;
  }

  public List<BankAction> getActionHistory()
  {
    //List<BankClient> b = new ArrayList<>();
    //for(i : )

    return bankActions;
  }

  public void addAction(BankAction action)
  {
    bankActions.add(action);
  }

  public void addMoney(int m)
  {
    this.money += m;
  }

  public void withdrawMoney(int m)
  {
    if(m > this.money)
    {
      System.out.println("Not enough money!\n");
    }
    else
    {
      this.money -= m;
    }
  }
}
