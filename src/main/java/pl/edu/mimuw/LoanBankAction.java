package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {

  private double interestRate;
  private double amountPaidOff;

  public LoanBankAction(double interestRate, double amountPaidOff, double totalAmount, Timestamp startTimestamp, Timestamp endTimestamp) {
    super(totalAmount, startTimestamp, endTimestamp);
    this.interestRate = interestRate;
    this.amountPaidOff = amountPaidOff;
  }
  
  public double getInterestRate() {
    return this.interestRate;
  }

  public double getAmountPaidOff() {
    return this.amountPaidOff;
  }

  public double getLeftToPayOff() {
    return this.totalAmount - this.amountPaidOff;
  }


  public String toString() {
    StringBuilder sb = new StringBuilder();
    
    sb.append("\n").append("     action type: Loan\n");
    sb.append("     amount loaned: ").append(totalAmount).append("\n");
    sb.append("     interest rate: ").append(interestRate).append("\n");
    sb.append("     start: ").append(startTimestamp).append(", end: ").append(endTimestamp).append("\n");
    sb.append("     amount paid off: ").append(amountPaidOff).append("\n");
    sb.append("     left to pay off: ").append(totalAmount - amountPaidOff).append("\n");
    
    return sb.toString();
  }
  
}
