package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction
{
  private double percentage;
  private String breakDeclaration;

  public DepositBankAction(double totalAmount, Timestamp startTimestamp, Timestamp endTimestamp, double percentage, String breakDeclaration)
  {
    this.totalAmount = totalAmount;
    this.startTimestamp = startTimestamp;
    this.endTimestamp = endTimestamp;
    this.percentage = percentage;
    this.breakDeclaration = breakDeclaration;
  }

  public double getPercentage() {
    return this.percentage;
  }

  public String getBreakDeclaration()
  {
    return this.breakDeclaration;
  }

  public String toString()
  {
    return this.percentage + " " + this.breakDeclaration;
  }

  // TODO:
  // - remove abstract modifier from this class
  // - this class has to contain extra fields other than LoanBankAction
  // - you have to design it's constructors/accessors/setters and implement some from BankAction
}
