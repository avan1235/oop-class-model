package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {

  private List<BankClient> allClients;

  Bank() {
    allClients = new ArrayList<>();
  }

  @Override
  public String toString() {
    var builder = new StringBuilder("Bank\n");
    for(var client : allClients) {
      builder.append(client.toString().replaceAll("(?m)^", "  "));
    }

    return builder.toString();
  }

  public List<BankClient> getAllClients() {
    return new ArrayList<>(allClients);
  }

  public void addClient(BankClient client) {
    allClients.add(client);
  }

  public BankClient getClient(int clientIndex) {
    final var clients = getAllClients();
    if (clientIndex >= clients.size())
      throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
