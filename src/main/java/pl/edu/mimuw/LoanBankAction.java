package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {
  private final int rate;

  public LoanBankAction(int amount, Timestamp startTime, Timestamp endTime, int rate) {
    super(amount, startTime, endTime);
    this.rate = rate;
  }

  public int getRate() {
    return rate;
  }

  @Override
  public String toString() {
    return "Action loan for: " + this.totalAmount() + " made at " + this.startTime + " ends at " + this.endTime +
      ", rate: " + this.rate+"%";
  }
}
