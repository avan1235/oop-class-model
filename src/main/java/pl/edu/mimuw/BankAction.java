package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction {
  protected double totalAmount;
  protected Timestamp startTimestamp;
  protected Timestamp endTimestamp;

  public double totalAmount()
  {
    return this.totalAmount;
  }

  public Timestamp getStartTimestamp()
  {
    return this.startTimestamp;
  }

  public Timestamp getEndTimestamp()
  {
    return this.endTimestamp;
  }

  @Override
  public abstract String toString();
}
