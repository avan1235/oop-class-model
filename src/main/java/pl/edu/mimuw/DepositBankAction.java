package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction
{
	public DepositBankAction(double _totalAmount, String _currency, Timestamp _startTimestamp, Timestamp _endTimestamp)
	{
		super(_totalAmount, _currency, _startTimestamp, _endTimestamp);
	}

	@Override
	public String toString()
	{
		var s = new StringBuilder();
		s.append("Total deposit amount: ").append(getTotalAmount()).append(' ').append(getCurrency()).append('\n')
				.append("Beginning of the deposit: ").append(getStartTimestamp().toLocalDateTime()).append('\n')
				.append("Termination of the deposit: ").append(getEndTimestamp().toLocalDateTime()).append('\n');
		return s.toString();
	}

	// TODO:
	// - this class has to contain extra fields other than LoanBankAction
	// - you have to design it's constructors/accessors/setters and implement some from BankAction
}
