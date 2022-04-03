package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction
{
	public DepositBankAction(double _totalAmount, String _currency, Timestamp _startTimestamp, Timestamp _endTimestamp, double _percentage)
	{
		super(_totalAmount, _currency, _startTimestamp, _endTimestamp);
		percentage = _percentage;
	}

	private final double percentage;

	public double getPercentage()
	{
		return percentage;
	}

	@Override
	public String toString()
	{
		var s = new StringBuilder();
		s.append("Total deposit amount: ").append(getTotalAmount()).append(' ').append(getCurrency()).append('\n')
				.append("Beginning of the deposit: ").append(getStartTimestamp().toLocalDateTime()).append('\n')
				.append("Termination of the deposit: ").append(getEndTimestamp().toLocalDateTime()).append('\n')
				.append("Percentage of the deposit: ").append(getPercentage()).append('\n');
		return s.toString();
	}
}
