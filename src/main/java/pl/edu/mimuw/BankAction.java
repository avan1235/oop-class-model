package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction
{
	protected double totalAmount;
	protected final String currency;
	protected final Timestamp startTimestamp;
	protected final Timestamp endTimestamp;

	public BankAction(double _totalAmount, String _currency, Timestamp _startTimestamp, Timestamp _endTimestamp)
	{
		totalAmount = _totalAmount;
		currency = _currency;
		startTimestamp = _startTimestamp;
		endTimestamp = _endTimestamp;
	}

	public double getTotalAmount()
	{
		return totalAmount;
	}

	public String getCurrency()
	{
		return currency;
	}

	public Timestamp getStartTimestamp()
	{
		return startTimestamp;
	}

	public Timestamp getEndTimestamp()
	{
		return endTimestamp;
	}

	@Override
	public abstract String toString();
}
