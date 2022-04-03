package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {

  private String acceptingBranch;

  DepositBankAction(double amount, Timestamp start, Timestamp end, String acceptingBranch) {
    super(amount, start, end);
    this.acceptingBranch = acceptingBranch;
  }

  public String getAcceptingBranch() {
    return acceptingBranch;
  }

  @Override
  public String toString() {
    return "DepositBankAction " + amount + ", " + start + ", " + end + ", " + acceptingBranch;
  }
}
