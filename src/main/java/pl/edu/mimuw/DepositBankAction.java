package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {
  double percentageGained;

  public DepositBankAction(double amount, Timestamp endTimestamp, double percentageGained) {
    super(amount, endTimestamp);
    this.percentageGained = percentageGained;
  }
  
  public DepositBankAction(double amount, Timestamp startTimestamp, Timestamp endTimestamp, double percentageGained) {
    super(amount, startTimestamp, endTimestamp);
    this.percentageGained = percentageGained;
  }


  @Override
  public String toString() {
    return "LOKATA: " + super.toString() + " ZAROBI: " + (percentageGained+1)*amount;
  }

  /**
   * @return zwraca polowe wplaconych pieniedzy za cene zmniejszenia o polowe przychodow
   */
  public double liquidateHalf() {
    this.amount=this.amount/2;
    this.percentageGained=this.percentageGained/2;
    return amount;
  }

  @Override
  public BankAction createCopy() {
    return new DepositBankAction(this.amount, this.endTimestamp, this.percentageGained);
  }
}
