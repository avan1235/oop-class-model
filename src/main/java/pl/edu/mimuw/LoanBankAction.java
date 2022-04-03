package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {

  private final String loanPurpose;
  private final int monthInstalment;

  public LoanBankAction(int amount, Timestamp start, Timestamp end, String loanPurpose, int monthInstalment) {
    super(amount, start, end);
    this.loanPurpose = loanPurpose;
    this.monthInstalment = monthInstalment;
  }

  public int income() {
    return (int) (this.amount - ((this.end.getYear() - this.start.getYear()) * 12 + (this.end.getMonth() - this.start.getMonth())) * this.monthInstalment);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("loan from: ");
    sb.append(this.start.toString());
    sb.append("\nto: ");
    sb.append(this.end.toString());
    sb.append("\nof ");
    sb.append(this.amount);
    sb.append("\nwith monthly instalment: ");
    sb.append(this.monthInstalment);
    sb.append("\nfor ");
    sb.append(this.loanPurpose);
    sb.append("\n");
    return sb.toString();
  }
}
