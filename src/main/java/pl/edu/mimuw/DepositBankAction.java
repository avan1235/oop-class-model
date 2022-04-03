package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {

  private double rateOfInterest;
  private boolean specialOfferApplied;

  public DepositBankAction(double amount, Timestamp begin, Timestamp end, double rate) {
    super(amount, begin, end);
    this.rateOfInterest = rate;
    this.specialOfferApplied = false;
  }

  public DepositBankAction(DepositBankAction other) {
    super(other.totalAmount, other.startTimestamp, other.endTimestamp);
    this.rateOfInterest = other.rateOfInterest;
    this.specialOfferApplied = other.specialOfferApplied;
  }

  public double getRateOfInterest() {
    return rateOfInterest;
  }

  public void applySpecialOffer() {
    if (!this.specialOfferApplied) {
      this.rateOfInterest *= 1.5;
      this.specialOfferApplied = true;
    }
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();

    sb.append("Deposit ");
    if (this.specialOfferApplied) {
      sb.append("with special offer, ");
    }

    sb.append("amount: " + this.totalAmount + ", ");
    sb.append("start: " + this.startTimestamp.toString() + ", ");
    sb.append("end: " + this.endTimestamp.toString());

    return sb.toString();
  }

  public DepositBankAction getCopy() {
    return new DepositBankAction(this);
  }
}
