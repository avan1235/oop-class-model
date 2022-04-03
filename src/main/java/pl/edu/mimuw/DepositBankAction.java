package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {

  double rate;
  double goal;
  int years;

  public DepositBankAction(double amount, Timestamp begin, Timestamp end, double rate, double goal) {
    super(amount, begin, end);
    this.rate = rate;
    this.goal = goal;
    double temp =  amount;
    while (temp<goal){
      this.years = this.years + 1;
      temp = temp + ((temp*rate)/100);
    }
  }

  public int getTime(){
    return this.years;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("Deposit Bank action:\n");
    result.append("   Amount of deposit: " + amount + "\n");
    result.append("   Rate: " + this.rate + "\n");
    result.append("   Goal: " + this.goal + "\n");
    result.append("   Years to goal: " + this.years + "\n");
    result.append("   Date of Deposit end: " + this.end + "\n");

    return result.toString();
  }

}
