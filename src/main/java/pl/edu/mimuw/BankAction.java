package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction {

  protected final double amount;
  protected final double interestRate;
  protected final Timestamp start;
  protected final Timestamp end;
  protected final double finalAmount;
  protected boolean finished;

  protected BankAction(double amount, double interestRate, Timestamp end) {
    this.amount = amount;
    this.interestRate = interestRate;
    this.start = new Timestamp(System.currentTimeMillis());
    this.end = end;
    this.finalAmount = this.amount + this.amount * this.interestRate;
    this.finished = false;
  }
  public BankAction(BankAction action) {
    this.amount = action.amount;
    this.interestRate = action.interestRate;
    this.start = action.start;
    this.end = action.end;
    this.finalAmount = action.finalAmount;
    this.finished = action.finished;
  }

  public abstract double totalAmount();

  public abstract BankAction copy();

  public Timestamp getStartTimestamp() {
    return this.start;
  }

  public Timestamp getEndTimestamp() {
    return this.end;
  }

  @Override
  public abstract String toString();
}
