package pl.edu.mimuw;

import java.sql.Timestamp;
import java.time.Instant;

public abstract class BankAction {
  protected double amount;
  protected final Timestamp startTimestamp;
  protected final Timestamp endTimestamp;

  protected BankAction(double amount, Timestamp endTimestamp) {
    this.amount = amount;
    this.startTimestamp = Timestamp.from(Instant.now());
    this.endTimestamp = endTimestamp;
  }
  /**
   * druga metoda, uzywana przy kopiowaniu - bo nie chcemy, by zmienialo nam startTimestamp na obecny czas
   */
  protected BankAction(double amount, Timestamp startTimestamp, Timestamp endTimestamp) {
    this.amount = amount;
    this.startTimestamp = startTimestamp;
    this.endTimestamp = endTimestamp;
  }
  
  /**
   * @return kopia tego BankAction
   */
  abstract public BankAction createCopy();

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
  
  public double getAmount() {
    return amount;
  }

  public Timestamp getStartTimestamp() {
    return startTimestamp;
  }

  public Timestamp getEndTimestamp() {
    return endTimestamp;
  }

}
