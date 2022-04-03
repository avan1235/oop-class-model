package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {

  private final double interestRate;
  private final double yearlyGrowthOfInterest;

  public DepositBankAction(int amount, Timestamp start, Timestamp end, double interestRate, double yearlyGrowthOfInterest) {
    super(amount, start, end);
    this.interestRate = interestRate;
    this.yearlyGrowthOfInterest = yearlyGrowthOfInterest;
  }

  public int income() {
    int income = 0;
    double tmpInterest = this.interestRate;
    for (int i = 0; i < (end.getYear() - start.getYear()); i++) {
      income += this.amount * tmpInterest;
      tmpInterest += yearlyGrowthOfInterest;
    }
    return income;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("loan from: ");
    sb.append(this.start.toString());
    sb.append("\nto: ");
    sb.append(this.end.toString());
    sb.append("\namount ");
    sb.append(this.amount);
    sb.append("\nwith interest rate ");
    sb.append(this.interestRate * 100);
    sb.append("% growing every year by ");
    sb.append(this.yearlyGrowthOfInterest * 100);
    sb.append("%\n");
    return sb.toString();
  }
  // TODO:
  // - remove abstract modifier from this class
  // - this class has to contain extra fields other than LoanBankAction
  // - you have to design it's constructors/accessors/setters and implement some from BankAction
}
