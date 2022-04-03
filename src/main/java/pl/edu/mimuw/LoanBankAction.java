package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {

  private String issuingBranch;
  private double collateralValue;

  LoanBankAction(double amount, Timestamp start, Timestamp end, String issuingBranch, double collateralValue) {
    super(-amount, start, end);
    this.issuingBranch = issuingBranch;
    this.collateralValue = collateralValue;
  }

  public String getIssuingBranch() {
    return issuingBranch;
  }

  public double getCollateralValue() {
    return collateralValue;
  }

  public double setCollateralValue(double collateralValue) {
    return this.collateralValue = collateralValue;
  }

  @Override
  public String toString() {
    return "LoanBankAction " + amount + ", " + start + ", " + end + ", " + issuingBranch + ", " + collateralValue;
  }
}
