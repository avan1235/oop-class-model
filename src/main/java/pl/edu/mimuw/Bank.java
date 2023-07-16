package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	List<BankClient> allClients;
	
	@Override
	public String toString() {
		var answer = new StringBuilder();
		answer.append("Total number of clients: ");
		answer.append(this.allClients.size());
		answer.append(".\n");
		if(allClients.size() > 0) {
			int maxAge = 0;
			for(var client: allClients) {
				maxAge = Math.max(maxAge, client.getAge());
			}
			answer.append("The oldest one is ");
			answer.append(maxAge);
			answer.append(" years old.");
		}
		return answer.toString();
	}
	
	public List<BankClient> getAllClients() {
		List<BankClient> copy = new ArrayList<BankClient>();
		for(var client: allClients) {
			String name = client.getName();
			String surname = client.getSurname();
			int age = client.getAge();
			String accountNumber = client.getAccountNumber();
			double balance = client.getBalance();
			List<BankAction> actionHistory = client.getActionHistory();
			copy.add(new BankClient(name, surname, age, accountNumber, balance, actionHistory));
		}
		return copy;
	}
	
	public void addClient(BankClient client) {
		allClients.add(client);
	}
	
	public BankClient getClient(int clientIndex) {
		final var clients = getAllClients();
		if (clientIndex < 0 || clientIndex >= clients.size()) {
			throw new IllegalArgumentException("Invalid client index");
		}
		return clients.get(clientIndex);
	}
}