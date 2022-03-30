package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {
  boolean isBiggerThanMillion;

  public DepositBankAction(double amount, Timestamp begin, Timestamp end) {
    super(amount, begin, end);
    if (amount > 1000000) {
      this.isBiggerThanMillion = true;
    } else {
      this.isBiggerThanMillion = false;
    }
  }

  public double getValofDeposit() {
    return this.amount;
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    if (isBiggerThanMillion) {
      sb.append("Deposit is bigger than million ");
    } else {
      sb.append("Deposit is smaller than million ");
    }
    return sb.toString();
  }
}
