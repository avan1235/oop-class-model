package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {

  private final String name;
  private final String country;
  private final ArrayList<BankClient> BankClients;

  public Bank(String name, String country){
    this.name = name;
    this.country = country;
    this.BankClients = new ArrayList<BankClient>();
  }

  @Override
  public String toString() {
    final StringBuilder result = new StringBuilder("Bank " + this.name + "\n Country: " + this.country);
    result.append("\n Clients:\n");
    for(BankClient client : BankClients){
      result.append("{\n");
      result.append("Name: " + client.getName() + "\n");
      result.append("Surname: " + client.getSurname() + "\n");
      result.append("Age: " + client.getAge() + "\n");
      result.append("City: " + client.getCity() + "\n");
      result.append("Account Number: " + client.getAccountNumber() + "\n");
      result.append("Balance: " + client.getBalance() + "\n");
      result.append("Account Actions: \n");
      for (BankAction action : client.getActionHistory()){
        result.append(" " + action.toString() + "\n");
      }
      result.append("}\n");
    }

    return result.toString();
  }

  public List<BankClient> getAllClients() {
    return new ArrayList<>(this.BankClients);
  }

  public void addClient(BankClient client) {
    this.BankClients.add(client);
  }

  public BankClient getClient(int clientIndex) {
    final var clients = getAllClients();
    if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
