package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction
{
	private double monthlyPaymentRate;

	public void setMonthlyPaymentRate(double _monthlyPaymentRate)
	{
		monthlyPaymentRate = _monthlyPaymentRate;
	}

	public double getMonthlyPaymentRate()
	{
		return monthlyPaymentRate;
	}

	public LoanBankAction(double _totalAmount, String _currency, Timestamp _startTimestamp, Timestamp _endTimestamp, double _monthlyPaymentRate)
	{
		super(_totalAmount, _currency, _startTimestamp, _endTimestamp);
		monthlyPaymentRate = _monthlyPaymentRate;
	}

	@Override
	public String toString()
	{
		var s = new StringBuilder();
		s.append("Total loan amount: ").append(getTotalAmount()).append('\n')
				.append("Beginning of the loan: ").append(getStartTimestamp().toLocalDateTime()).append('\n')
				.append("Termination of the loan: ").append(getEndTimestamp().toLocalDateTime()).append('\n')
				.append("Monthly payment rate: ").append(getMonthlyPaymentRate()).append('\n');
		return s.toString();
	}
}
