package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction
{
	public LoanBankAction(double _totalAmount, String _currency, Timestamp _startTimestamp, Timestamp _endTimestamp)
	{
		super(_totalAmount, _currency, _startTimestamp, _endTimestamp);
	}

	@Override
	public String toString()
	{
		var s = new StringBuilder();
		s.append("Total loan amount: ").append(getTotalAmount()).append('\n')
				.append("Beginning of the deposit: ").append(getStartTimestamp().toLocalDateTime()).append('\n')
				.append("Termination of the deposit: ").append(getEndTimestamp().toLocalDateTime()).append('\n');
		return s.toString();
	}

	// TODO:
	// - this class has to contain extra fields other than DepositBankAction
	// - you have to design it's constructors/accessors/setters and implement some from BankAction
}
