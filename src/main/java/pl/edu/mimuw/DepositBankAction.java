package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {
  public DepositBankAction(double amount, Timestamp startTimestamp, Timestamp endTimestamp) {
    super(amount, startTimestamp, endTimestamp);
  }

  // TODO:
  // - remove abstract modifier from this class
  // - this class has to contain extra fields other than LoanBankAction
  // - you have to design it's constructors/accessors/setters and implement some from BankAction

  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("DepositBankAction {");
    stringBuilder.append(", \n"+this.generalInfo());
    stringBuilder.append("\n}");

    return stringBuilder.toString();
  }
}
