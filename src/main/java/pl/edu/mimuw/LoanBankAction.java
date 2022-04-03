package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction
{
  private final int interestInterval;
  private final double pledge;

  public LoanBankAction(double totalAmount, Timestamp startTimestamp, Timestamp endTimestamp, int interestInterval, double pledge)
  {
    this.totalAmount = totalAmount;
    this.startTimestamp = startTimestamp;
    this.endTimestamp = endTimestamp;
    this.interestInterval = interestInterval;
    this.pledge = pledge;
  }

  public int getInterestInterval()
  {
    return this.interestInterval;
  }

  public double getPledge()
  {
    return this.pledge;
  }

  public String toString()
  {
    return "Loan " + this.interestInterval + " " + this.pledge;
  }
}
