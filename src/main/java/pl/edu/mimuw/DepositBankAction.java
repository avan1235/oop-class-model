package pl.edu.mimuw;

import java.sql.Timestamp;

public class DepositBankAction extends BankAction {
	private final double rate;
	
	public DepositBankAction(double amount, Timestamp begin, Timestamp end, double rate) {
		super(amount, begin, end);
		this.rate = rate;
	}
	
	public double getRate() {
		return this.rate;
	}
	
	public String toString() {
		return "Loan\nTotal amount: " + this.amount + "\nRate: " + this.rate + "\n";
	}
}