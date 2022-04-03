package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {

  private final double interestRate;
  private final double cost;

  public LoanBankAction(double amount, Timestamp begin, Timestamp end, double interestRate, double cost) {
    super(amount, begin, end);
    this.interestRate = interestRate; 
    this.cost = cost;
  }
  
  public double getAmountToRepay(Timestamp moment) {
    long miliseconds = moment.getTime() - begin.getTime();
    return this.amount * (1.0 + interestRate) * (miliseconds / (1000 * 60 * 60 * 24)) / 365.0 + cost;
  }

  public String toString() {
    return String.valueOf("AMOUNT: " + this.amount + "BEGIN: " + this.begin + "END: " + this.end + "INTEREST RATE: " + this.interestRate + "COST: " + this.cost);  
  }
}
