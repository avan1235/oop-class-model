package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private List<BankClient> allClients;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    final var clients = getAllClients();
    for (int i = 0; i < clients.size(); i++) {
      sb.append(clients.get(i).toString());
      sb.append("\n");
    }
    return sb.toString();
  }

  public List<BankClient> getAllClients() {
    final var clients = getAllClients();
    List<BankClient> overview = new ArrayList<>();
    for (int i = 0; i < clients.size(); i++) {
      overview.add(clients.get(i).createCopy());
    }
    return overview;
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
