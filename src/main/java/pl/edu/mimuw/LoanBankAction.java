package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {
  double percentage;

  public LoanBankAction(double amount, double percentage, Timestamp startTimestamp, Timestamp endTimestamp) {
    super(amount, startTimestamp, endTimestamp);
    this.percentage = percentage;
  }

  public double getReturn() {
    return (this.amount * this.percentage / 100);
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    sb.append("Loan value is ").append(this.amount);
    sb.append("with percentage ").append(this.percentage);
    return sb.toString();
  }
}
