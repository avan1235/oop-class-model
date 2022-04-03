package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class BankClient {

  private String name;
  private String surname;
  private int age;
  private String accountNumber;
  private List<BankAction> actionHistory;

  public BankClient(
    String name,
    String surname,
    int age,
    String accountNumber
  ) {
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

  /**
   * @return zwraca kopie listy akcji wypelniona kopiami tych akcji
   */
  public List<BankAction> getActionHistory() {
    if (actionHistory == null) {
      return null;
    }
    List<BankAction> overview = new ArrayList<>();
    for (int i = 0; i < actionHistory.size(); i++) {
      overview.add(actionHistory.get(i).createCopy());
    }
    return actionHistory;
  }

  public BankClient createCopy() {
    return new BankClient(
      this.name,
      this.surname,
      this.age,
      this.accountNumber
    );
  }

  /**
   * splaca tyle dlugow klienta ile moze, jesli jakies zobowiazanie spadnie do zera, jest likwidowane z listy
   * @param amount kwota przeznaczona na splate wszytkich dlugow
   * @return zwraca pozostala kwote
   */
  public double repayDebt(double amount) {
    int i = 0;
    if (actionHistory.isEmpty()) {
      return amount;
    } else {
      while (i < actionHistory.size()) {
        var action = actionHistory.get(i);
        if (action instanceof LoanBankAction) {
          amount = ((LoanBankAction) action).repaySome(amount);
          if (((LoanBankAction) action).getDueHowMuch() == 0) {
            actionHistory.remove(i);
          } else {
            i++;
          }
          if(amount==0){
            return amount;
          }
        } else {
          i++;
        }
      }
    }
    return amount;
  }

  /**
   * @return zwraca pieniadze uzyskane z akcji liquidateHalf na kazdym depozycie
   */
  public double liqudiateHalfDeposits(){
    int i = 0;
    double amount = 0;
    if (actionHistory.isEmpty()) {
      return amount;
    } else {
      while (i < actionHistory.size()) {
        var action = actionHistory.get(i);
        if (action instanceof DepositBankAction) {
          amount = amount + ((DepositBankAction) action).liquidateHalf();
        }
        i++;
      }
    return amount;
    }
  }
  public void addAction(BankAction action) {
    actionHistory.add(action);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name + " ");
    sb.append(surname + " ");
    sb.append(age + "\n");
    sb.append(accountNumber + "\n");
    for (int i = 0; i < actionHistory.size(); i++) {
      sb.append(actionHistory.get(i).toString() + "\n");
    }
    return sb.toString();
  }
}
