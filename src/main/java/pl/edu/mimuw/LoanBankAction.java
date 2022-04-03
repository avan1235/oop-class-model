package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {

  double dueHowMuch;

  public LoanBankAction(
    double amount,
    Timestamp endTimestamp,
    double percentageToRepay
  ) {
    super(amount, endTimestamp);
    this.dueHowMuch = (1 + percentageToRepay) * amount;
  }

  public LoanBankAction(
    double amount,
    Timestamp startTimestamp,
    Timestamp endTimestamp,
    double dueHowMuch
  ) {
    super(amount, startTimestamp, endTimestamp);
    this.dueHowMuch = dueHowMuch;
  }

/**
 * 
 * @param amount ilosc pieniedzy, jaka klient ma na splate dlugu
 * @return ile pozostalo z tych pieniedzy
 */
  public double repaySome(double amount) {
    if (amount > dueHowMuch) {
      var repaid = dueHowMuch;
      dueHowMuch = 0;
      return amount - repaid;
    } else {
      dueHowMuch = dueHowMuch - amount;
      return 0;
    }
  }

  @Override
  public String toString() {
    return "POŻYCZKA: " + super.toString() + " DO SPLATY: " + dueHowMuch;
  }

  public double getDueHowMuch() {
    return dueHowMuch;
  }

  @Override
  public BankAction createCopy() {
    return new LoanBankAction(
      this.amount,
      this.startTimestamp,
      this.endTimestamp,
      this.dueHowMuch
    );
  }
}
