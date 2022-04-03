package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {
  final private double intrestRate;

  public DepositBankAction(double amount, double intrestRate, Timestamp startTimestamp, Timestamp endTimestamp) {
    super(amount, startTimestamp, endTimestamp);
    this.intrestRate = intrestRate;
  }

  public double getIntrestRate() {
    return this.intrestRate;
  }

  public void extendDeposit(Timestamp endTimestamp) {
    if (this.endTimestamp.before(endTimestamp)) {
      this.endTimestamp = endTimestamp;
    }
  }

  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("DepositBankAction {");
    stringBuilder.append(" \nintrest rate: ").append(this.intrestRate);
    stringBuilder.append(", \n" + this.generalInfo());
    stringBuilder.append("}");

    return stringBuilder.toString();
  }
}
