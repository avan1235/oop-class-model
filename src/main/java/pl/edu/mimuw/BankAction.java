package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction {
  protected double amount;
  protected final Timestamp startTimestamp;
  protected Timestamp endTimestamp;

  protected BankAction(double amount, Timestamp startTimestamp, Timestamp endTimestamp) {
    this.amount = amount;
    this.startTimestamp = startTimestamp;
    this.endTimestamp = endTimestamp;
  }

  public double totalAmount() {
    return this.amount;
  }

  public Timestamp getStartTimestamp() {
    return this.startTimestamp;
  }

  public Timestamp getEndTimestamp() {
    return this.endTimestamp;
  }

  protected String generalInfo() {
    final StringBuilder stringBuilder = new StringBuilder("Duration {");
    stringBuilder.append("\ntotal amount: ").append(this.amount);
    stringBuilder.append(" \nbegan: ").append(this.startTimestamp.toString());
    stringBuilder.append(", \nend: ").append(this.endTimestamp.toString());
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  @Override
  public abstract String toString();
}
