package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {
  private Timestamp payBackFrequency;
  private double intrestRate;

  public LoanBankAction(double amount, double intrestRate, Timestamp startTimestamp, Timestamp endTimestamp, Timestamp payBackFrequency) {
    super(amount, startTimestamp, endTimestamp);
    this.intrestRate = intrestRate;
    this.payBackFrequency = payBackFrequency;
  }

  public double getIntrestRate() {
    return this.intrestRate;
  }

  public void payBackFraction(double amount) {
    amount /= 1 + intrestRate;
    this.amount -= amount;
  }

  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("DepositBankAction {");
    stringBuilder.append(" \nintrest rate: ").append(this.intrestRate);
    stringBuilder.append(", \n" + this.generalInfo());
    stringBuilder.append(", \npayBackFrequency: " + this.payBackFrequency.toString());
    stringBuilder.append("}");

    return stringBuilder.toString();
  }
}
