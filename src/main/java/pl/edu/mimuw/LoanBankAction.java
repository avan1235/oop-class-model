package pl.edu.mimuw;

import java.sql.Timestamp;

public class LoanBankAction extends BankAction {
	private final double installment;
	
	public LoanBankAction(double amount, Timestamp begin, Timestamp end, double installment) {
		super(amount, begin, end);
		this.installment = installment;
	}
	
	public double getInstallment() {
		return this.installment;
	}
	
	public String toString() {
		return "Deposit\nTotal amount: " + this.amount + "\nInstallment: " + this.installment + "\n";
	}
}