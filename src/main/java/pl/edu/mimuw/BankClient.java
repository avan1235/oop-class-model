package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class BankClient {
	private final String name;
	private final String surname;
	private int age;
	private final String accountNumber;
	private double balance;
	private List<BankAction> actionHistory;
	
	public BankClient(String name, String surname, int age, String accountNumber, double balance) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.actionHistory = new ArrayList<BankAction>();
	}
	
	public BankClient(String name, String surname, int age, String accountNumber, double balance, List<BankAction> actionHistory) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.actionHistory = actionHistory;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public List<BankAction> getActionHistory() {
		return this.actionHistory;
	}
	
	public void addAction(BankAction action) {
		this.actionHistory.add(action);
	}
	
	public boolean withdraw(double amount) {
		if(amount > balance) {
			return false;
		}
		else {
			balance -= amount;
			return true;
		}
	}
	
	void birthday() {
		System.out.println("Happy birthday!");
		this.age++;
	}
}