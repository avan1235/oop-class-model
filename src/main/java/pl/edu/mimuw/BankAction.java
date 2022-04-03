package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction {

  protected final double amount;

  protected final Timestamp start;

  protected final Timestamp end;

  protected BankAction(double amount, Timestamp start, Timestamp end) {
    this.amount = amount;
    this.start = start;
    this.end = end;
  }

  public double getAmount() {
    return this.amount;
  }

  public Timestamp getStartTimestamp() {
    return this.start;
  }

  public Timestamp getEndTimestamp() {
    return this.end;
  }

  @Override
  public abstract String toString();

  /**
   * @return total number of months between start and end.
   */
  protected int getTotalMonths() {
    final var start = this.getStartTimestamp().toLocalDateTime();
    final var end = this.getEndTimestamp().toLocalDateTime();

    return (end.getMonthValue() - start.getMonthValue()) + (end.getYear() - start.getYear()) * 12;
  }
}
