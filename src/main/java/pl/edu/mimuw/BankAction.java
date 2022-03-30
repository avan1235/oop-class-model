package pl.edu.mimuw;

import java.sql.Timestamp;
import java.time.Instant;

public abstract class BankAction {
  protected final double amount;
  protected final Timestamp startTimestamp;
  protected final Timestamp endTimestamp;

  protected BankAction(double amount, Timestamp endTimestamp) {
    this.amount = amount;
    this.startTimestamp = Timestamp.from(Instant.now());
    this.endTimestamp = endTimestamp;
  }

  public double totalAmount() {
    return amount;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(amount);
    sb.append(" ");
    sb.append(startTimestamp);
    sb.append(" ");
    sb.append(endTimestamp);
    return sb.toString();
  }

  public Timestamp getStartTimestamp() {
    return startTimestamp;
  }

  public Timestamp getEndTimestamp() {
    return endTimestamp;
  }

}
