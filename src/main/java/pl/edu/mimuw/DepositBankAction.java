package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {
  double percentageGained;

  public DepositBankAction(double amount, Timestamp endTimestamp, double percentageGained) {
    super(amount, endTimestamp);
    this.percentageGained = percentageGained;
  }

  public liquidateHalf(){

  }

  @Override
  public String toString() {
    return "LOKATA: " + super.toString();
  }
}
