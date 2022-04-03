package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {

  private final double interestRate;
  private final double bonus;

  public DepositBankAction(double amount, Timestamp begin, Timestamp end, double interestRate, double bonus) {
    super(amount, begin, end);
    this.interestRate = interestRate; 
    this.bonus = bonus;
  }
  
  public double getCollectedAmount(Timestamp moment) {
    long miliseconds = moment.getTime() - begin.getTime();
    return this.amount * (1.0 + interestRate) * (miliseconds / (1000 * 60 * 60 * 24)) / 365.0 + bonus;
  }

  public String toString() {
    return String.valueOf("AMOUNT: " + this.amount + " BEGIN: " + this.begin + " END: " + this.end + " INTEREST RATE: " + this.interestRate + " BONUS: " + this.bonus);  
  }
}
