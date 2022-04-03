package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class BankClient
{
	private final String name;
	private final String surname;
	private final int age;
	private final String accountNumber;
	private double money;
	private final String currency;
	private ArrayList <BankAction> actionHistory;

	public BankClient(String _name, String _surname, int _age, String _accountNumber, String _currency)
	{
		name = _name;
		surname = _surname;
		age = _age;
		accountNumber = _accountNumber;
		money = 0;
		currency = _currency;
		actionHistory = new ArrayList <BankAction>();
	}

	public String getName()
	{
		return name;
	}

	public String getSurname()
	{
		return surname;
	}

	public int getAge()
	{
		return age;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public double getMoney()
	{
		return money;
	}

	public String getCurrency()
	{
		return currency;
	}

	public List <BankAction> getActionHistory()
	{
		return actionHistory;
	}

	public BankClient addAction(BankAction action)
	{
		actionHistory.add(action);
		money += action.getTotalAmount();
		return this;
	}

	public void confiscateAssets()
	{
		money = 0;
	}
}
