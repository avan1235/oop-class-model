package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {
  
  private String bankID; // ID number of the bank branch the money was deposited at.

  public DepositBankAction(String bankID, double totalAmount, Timestamp startTimestamp, Timestamp endTimestamp) {
    super(totalAmount, startTimestamp, endTimestamp);
    this.bankID = bankID;
  }

  public String getBankID() {
    return this.bankID;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    
    sb.append("\n").append("     action type: Deposit\n");
    sb.append("     bank ID: ").append(bankID).append("\n");
    sb.append("     amount deposited: ").append(totalAmount).append("\n");
    sb.append("     start: ").append(startTimestamp).append(", end: ").append(endTimestamp).append("\n");
    
    return sb.toString();
  }

}
