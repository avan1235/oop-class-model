package pl.edu.mimuw;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

public class DepositBankAction extends BankAction {

  private final int percent;

  public DepositBankAction(double amount, Timestamp start, Timestamp end, int percent) {
    super(amount, start, end);
    this.percent = percent;
  }

  /**
   * @return string representation of the deposit action.
   */
  @Override
  public String toString() {
    final var sb = new StringBuilder();
    final var months = this.getTotalMonths();
    final var initial = new BigDecimal(String.valueOf(this.amount)).setScale(2, RoundingMode.HALF_UP);
    final var revenue = new BigDecimal(String.valueOf(this.calculateRevenue())).setScale(2, RoundingMode.HALF_UP);

    sb.append("Deposited ").append(initial).append("$ at percentage gain per year: ").append(this.percent)
      .append("% on ").append(this.getStartTimestamp().toLocalDateTime().toLocalDate()).append(" until ")
      .append(this.getEndTimestamp().toLocalDateTime().toLocalDate()).append(" for a total of: ")
      .append(months).append(" month");
    if (months > 1 || months == 0) {
      sb.append("s");
    }
    sb.append(" and will have: ").append(revenue).append("$ at the end of the deposit.");

    return sb.toString();
  }

  /**
   * Uses the formula: amount * (1 + percent / 12*100) ^ months to calculate the revenue
   * (percent is divided by 12 because it is in percents per year and capitalization is per month).
   *
   * @return revenue of the deposit.
   */
  private double calculateRevenue() {
    final var months = this.getTotalMonths();
    return this.amount * Math.pow(1 + (double) this.percent / (12 * 100), months);
  }
}
