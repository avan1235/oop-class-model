package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {
  private final boolean isExtendable;

  public LoanBankAction(double total, Timestamp start, Timestamp end, boolean isExtendable) {
    super(total, start, end);
    this.isExtendable = isExtendable;
  }

  public LoanBankAction(LoanBankAction other) {
    super(other.totalAmount, other.startTimestamp, other.endTimestamp);
    this.isExtendable = other.isExtendable;
  }

  public void extendByWeek() {
    if (this.isExtendable) {
      long extendedMillis = 7 * 24 * 60 * 60 * 1000;
      this.endTimestamp.setTime(this.endTimestamp.getTime() + extendedMillis);
    }
  }


  public boolean isExtendable() {
    return isExtendable;
  }

  public String toString() {
    var sb = new StringBuilder();

    sb.append("Loan ");
    if (this.isExtendable) {
      sb.append("extendable, ");
    } else {
      sb.append("non-extendable, ");
    }

    sb.append("amount: " + this.totalAmount + ", ");
    sb.append("start: " + this.startTimestamp.toString() + ", ");
    sb.append("end: " + this.endTimestamp.toString());

    return sb.toString();
  }

  public LoanBankAction getCopy() {
    return new LoanBankAction(this);
  }
}
