package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank
{

	private final String bankName;
	private final String bankCountry;
	private final String bankCity;
	private final String swiftCode;
	private ArrayList <BankClient> clientList;

	public Bank(String _bankName, String _bankCountry, String _bankCity, String _swiftCode)
	{
		bankName = _bankName;
		bankCountry = _bankCountry;
		bankCity = _bankCity;
		swiftCode = _swiftCode;
		clientList = new ArrayList <BankClient>();
	}

	@Override
	public String toString()
	{
		var s = new StringBuilder();
		s.append("Bank name: ").append(getBankName()).append('\n')
				.append("Bank country: ").append(getBankCountry()).append('\n')
				.append("Bank city: ").append(getBankCity()).append('\n')
				.append("Bank SWIFT code: ").append(getSwiftCode()).append('\n')
				.append("Number of bank's clients: ").append(getAllClients().size()).append("\n\n")
				.append("Clients' personal data:\n");
		for (var client : getAllClients())
			s.append(client.getName()).append(' ').append(client.getSurname())
					.append(", aged ").append(client.getAge())
					.append(", account number ").append(client.getAccountNumber())
					.append(" with ").append(client.getMoney()).append(client.getCurrency()).append('\n');

		return s.toString();
	}

	public String getBankName()
	{
		return bankName;
	}

	public String getBankCountry()
	{
		return bankCountry;
	}

	public String getBankCity()
	{
		return bankCity;
	}

	public String getSwiftCode()
	{
		return swiftCode;
	}

	public List<BankClient> getAllClients()
	{
		return clientList;
	}

	public void addClient(BankClient client)
	{
		clientList.add(client);
	}

	public BankClient getClient(int clientIndex)
	{
		final var clients = getAllClients();
		if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
		return clients.get(clientIndex);
	}
}
