package pl.edu.mimuw;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public abstract class BankAction {
  protected double totalAmount;
  protected Timestamp startTimestamp;
  protected Timestamp endTimestamp;

  public BankAction(double totalAmount, Timestamp startTimestamp, Timestamp endTimestamp) {
    this.totalAmount = totalAmount;
    this.startTimestamp = startTimestamp;
    this.endTimestamp = endTimestamp;
  }


  public double getTotalAmount() {
    return totalAmount;
  }

  public Timestamp getStartTimestamp() {
    return startTimestamp;
  }

  public Timestamp getEndTimestamp() {
    return endTimestamp;
  }

  @Override
  public abstract String toString();

  public abstract BankAction getCopy();
}
