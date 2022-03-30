package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction
{
  private int interestInterval;
  private double pledge;

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
    return this.interestInterval + " " + this.pledge;
  }
  // TODO:
  // - remove abstract modifier from this class
  // - this class has to contain extra fields other than DepositBankAction
  // - you have to design it's constructors/accessors/setters and implement some from BankAction
}
