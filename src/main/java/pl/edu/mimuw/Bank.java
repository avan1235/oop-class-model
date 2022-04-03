package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {

  private final String name;
  private final List<BankClient> allClients;

  public Bank(String name) {
    this.name = name;
    allClients = new ArrayList<>();
  }
  
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    
    for(BankClient client : allClients) {
        s.append(client.getAccountNumber());
        s.append(", ");
    }
        
    String info = s.toString();
    return "BANK: " + name + " CLIENTS: " + info;
  }

  public List<BankClient> getAllClients() {
    return new ArrayList<>(allClients);
  }

  public void addClient(BankClient client) {
    allClients.add(client);
  }

  public BankClient getClient(int clientIndex) {
    final List<BankClient> clients = getAllClients();
    if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
