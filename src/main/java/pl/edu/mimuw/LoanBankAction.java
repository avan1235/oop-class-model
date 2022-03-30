package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class LoanBankAction extends BankAction {

  protected LoanBankAction(double amount, Timestamp startTimestamp, Timestamp endTimestamp) {
    super(amount, endTimestamp);
  }

  @Override
  public String toString() {
    return "POŻYCZKA: " + super.toString();
  }
}
