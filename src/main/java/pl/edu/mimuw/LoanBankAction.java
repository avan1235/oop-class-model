package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class LoanBankAction extends BankAction {
  public LoanBankAction(double amount, Timestamp startTimestamp, Timestamp endTimestamp) {
    super(amount, startTimestamp, endTimestamp);
  }

  // TODO:
  // - remove abstract modifier from this class
  // - this class has to contain extra fields other than DepositBankAction
  // - you have to design it's constructors/accessors/setters and implement some from BankAction
}
