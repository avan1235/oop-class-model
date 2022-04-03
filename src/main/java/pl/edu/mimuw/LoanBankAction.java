package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {

  double rate;
  double debt;

  public LoanBankAction(double amount, Timestamp begin, Timestamp end, double rate){
    super(amount, begin, end);
    this.rate = rate;
    this.debt = (amount * rate)/100 + amount;
  }

  public double getDebt(){
    return this.debt;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("Loan Bank action:\n");
    result.append("   Amount of loan: " + amount + "\n");
    result.append("   Rate: " + this.rate + "\n");
    result.append("   Debt: " + this.debt + "\n");
    result.append("   Deadline: " + this.end + "\n");

    return result.toString();
  }
}
