package pl.edu.mimuw;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

public class LoanBankAction extends BankAction {

  private final int loanRate;

  public LoanBankAction(double amount, Timestamp start, Timestamp end, int loanRate) {
    super(amount, start, end);
    this.loanRate = loanRate;
  }

  /**
   * @return string representation of the loan action.
   */
  @Override
  public String toString() {
    final var sb = new StringBuilder();
    final var months = this.getTotalMonths();
    final var initial = new BigDecimal(String.valueOf(this.amount)).setScale(2, RoundingMode.HALF_UP);
    final var expenses = new BigDecimal(String.valueOf(this.calculateExpenses())).setScale(2, RoundingMode.HALF_UP);

    sb.append("Loaned ").append(initial).append("$ at (yearly) rate: ").append(this.loanRate).append("% on ")
      .append(this.getStartTimestamp().toLocalDateTime().toLocalDate()).append(" until ")
      .append(this.getEndTimestamp().toLocalDateTime().toLocalDate()).append(" for a total of: ")
      .append(months).append(" month");
    if (months > 1 || months == 0) {
      sb.append("s");
    }
    sb.append(" and will have to pay: ").append(expenses).append("$ back.");

    return sb.toString();
  }

  /**
   * Uses the formula: amount * (1 + percent / 12*100) ^ months to calculate the expenses of the loan
   * (percent is divided by 12 because it is in percents per year and capitalization is per month).
   *
   * @return total amount of expenses.
   */
  private double calculateExpenses() {
    final var months = this.getTotalMonths();
    return this.amount * Math.pow(1 + (double) this.loanRate / (12 * 100), months);
  }
}
