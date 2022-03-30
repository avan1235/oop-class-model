package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {

  private String issuingBranch;
  private double collateralValue;
  // TODO:
  // - remove abstract modifier from this class
  // - this class has to contain extra fields other than DepositBankAction
  // - you have to design it's constructors/accessors/setters and implement some
  // from BankAction

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

  @Override
  public String toString() {
    return "LoanBankAction " + amount + ", " + start + ", " + end + ", " + issuingBranch + ", " + collateralValue;
  }
}
