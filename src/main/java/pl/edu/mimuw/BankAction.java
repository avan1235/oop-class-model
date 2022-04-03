package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction {

  protected final int amount;
  protected final Timestamp start;
  protected final Timestamp end;

  public BankAction(int amount, Timestamp start, Timestamp end) {
    this.amount = amount;
    this.start = start;
    this.end = end;
  }

  public double totalAmount() {
    return amount;
  }

  public Timestamp getStartTimestamp() {
    return this.start;
  }

  public Timestamp getEndTimestamp() {
    return this.end;
  }


  @Override
  public abstract String toString();

  public abstract int income();
}
