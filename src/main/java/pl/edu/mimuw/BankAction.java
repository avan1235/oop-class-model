package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction {

  protected final double totalAmount;
  protected final Timestamp startTimestamp;
  protected final Timestamp endTimestamp;

  protected BankAction(double totalAmount, Timestamp startTimestamp, Timestamp endTimestamp) {
    this.totalAmount = totalAmount;
    this.startTimestamp = startTimestamp;
    this.endTimestamp = endTimestamp;
  }

  public double getTotalAmount() {
    return this.totalAmount;
  }

  public Timestamp getStartTimestamp() {
    return this.startTimestamp;
  }

  public Timestamp getEndTimestamp() {
    return this.endTimestamp;
  }

  @Override
  public abstract String toString();
}
