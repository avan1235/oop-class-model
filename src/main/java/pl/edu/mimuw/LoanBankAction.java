package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {
  final double penalty;

  public LoanBankAction(double amount, double interestRate, Timestamp end, double penalty) {
    super(amount, interestRate, end);
    this.penalty = penalty;
  }

  public LoanBankAction(LoanBankAction action) {
    super(action);
    this.penalty = action.penalty;
  }

  public boolean isPayed() {
    return this.finished;
  }

  public boolean pay(double amount) {
    if (amount == this.toPay()) {
      this.finished = true;
      return true;
    }
    else {
      return false;
    }
  }

  public double totalAmount() {
    if (this.isPayed()) {
      return  0;
    }
    return this.amount;
  }

  public double toPay() {
    if (this.getEndTimestamp().getTime() <= System.currentTimeMillis()) {
      return this.finalAmount + this.penalty;
    }
    else {
      return this.finalAmount;
    }
  }

  public String toString() {
    var sb = new StringBuilder();
    sb.append("Time loaned: ").append(this.getEndTimestamp()).append("\nEnd time: ").append(this.getStartTimestamp())
      .append("\n Amount: ").append(this.totalAmount()).append("\nTo be payed: ").append(this.toPay());

    return sb.toString();
  }

  public LoanBankAction copy() {
    return new LoanBankAction(this);
  }


}
