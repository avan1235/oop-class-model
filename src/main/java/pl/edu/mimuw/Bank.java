package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private List<BankClient> allClients;

  public Bank() {
    this.allClients = new ArrayList<BankClient>();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Clients:\n");
    for (var cli: this.allClients) {
      sb.append(cli.toString()).append('\n');
    }
    
    return sb.toString();
  }

  public List<BankClient> getAllClients() {
    List<BankClient> allClients = new ArrayList<BankClient>();
    
    allClients = this.allClients;
    return allClients;
  }

  public void addClient(BankClient client) {
    this.allClients.add(client);
  }

  public BankClient getClient(int clientIndex) {
    final var clients = getAllClients();
    if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
