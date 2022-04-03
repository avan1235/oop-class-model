package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction {
  protected double amount;
  protected Timestamp start, end;

  BankAction(double amount, Timestamp start, Timestamp end) {
    this.amount = amount;
    this.start = start;
    this.end = end;
  }

  public double totalAmount() {
    return amount;
  }

  public Timestamp getStartTimestamp() {
    return start;
  }

  public Timestamp getEndTimestamp() {
    return end;
  }

  @Override
  public abstract String toString();
}
