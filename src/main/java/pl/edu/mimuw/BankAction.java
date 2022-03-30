package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction {
  protected final int amount;
  protected final Timestamp startTime;
  protected final Timestamp endTime;

  public BankAction(int amount, Timestamp startTime, Timestamp endTime) {
    this.amount = amount;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public double totalAmount() {
    return amount;
  }

  public Timestamp getStartTimestamp() {
    return this.startTime;
  }

  public Timestamp getEndTimestamp() {
    return this.endTime;
  }

  @Override
  public abstract String toString();
}
