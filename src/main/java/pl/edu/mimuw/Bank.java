package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {

  private final String owner;
  private final String bankName;
  private final List<BankClient> clientList;

  public Bank(String owner, String bankName) {
    this.owner = owner;
    this.bankName = bankName;
    this.clientList = new ArrayList<BankClient>();
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    sb.append(this.bankName).append(" owned by ").append(this.owner).append(" with ")
      .append(clientList.size()).append(" clients");
    return sb.toString();
  }

  public List<BankClient> getAllClients() {
    final var newList = new ArrayList<BankClient>();

    for (var client: this.clientList) {
      newList.add(client.copy());
    }

    return newList;
  }

  public void addClient(BankClient client) {
    this.clientList.add(client);
  }

  public BankClient getClient(int clientIndex) {
    final var clients = getAllClients();
    if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
