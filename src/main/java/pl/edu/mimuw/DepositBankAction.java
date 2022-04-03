package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {
  public DepositBankAction(double amount, double interestRate, Timestamp end) {
    super(amount, interestRate, end);
  }

  public DepositBankAction(DepositBankAction action) {
    super(action);
  }

  public double withdrawal() {
    if (!this.finished) {
      this.finished = true;
      if (this.canBeWithdrawn()) {
        return this.amount;
      }
      else {
        return this.finalAmount;
      }
    }
    return 0;
  }

  public boolean isWithdrawn() {
    return this.finished;
  }

  public boolean canBeWithdrawn() {
    return this.getEndTimestamp().getTime() <= System.currentTimeMillis();
  }

  public double totalAmount(){
    if (!this.isWithdrawn()) {
      if (this.canBeWithdrawn()) {
        return this.finalAmount;
      } else {
        return this.amount;
      }
    }
    else {
      return 0;
    }
  }

  public double getFinalAmount() {
    return this.finalAmount;
  }

  public String toString() {
    var sb = new StringBuilder();
    sb.append("Time deposited: ").append(this.getEndTimestamp()).append("\nEnd time: ").append(this.getStartTimestamp())
      .append("\nCurrent amount: ").append(this.totalAmount());

    return sb.toString();
  }

  public DepositBankAction copy() {
    return new DepositBankAction(this);
  }

}
