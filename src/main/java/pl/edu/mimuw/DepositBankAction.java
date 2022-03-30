package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {
  private final int profit;

  public DepositBankAction(int amount, Timestamp startTime, Timestamp endTime, int profit) {
    super(amount, startTime, endTime);
    this.profit = profit;
  }

  public int getProfit() {
    return  profit;
  }

  @Override
  public String toString() {
    return "Action deposit for: " + this.totalAmount() + " made at " + this.startTime + " ends at " + this.endTime +
            ", profit: " + this.profit;
  }
}
