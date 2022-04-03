package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private final List<BankClient> clientList;

  public Bank() {
    this.clientList = new ArrayList<>();
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();

    for (BankClient bc : this.clientList) {
      sb.append(bc.toString());
    }

    return sb.toString();
  }

  public List<BankClient> getAllClients() {
    List<BankClient> l = new ArrayList<>();

    for (BankClient bc : this.clientList) {
      l.add(bc.getCopy());
    }

    return l;
  }

  public int getNumberOfClients() {
    return this.clientList.size();
  }

  public void addClient(BankClient client) {
    this.clientList.add(client);
  }

  public BankClient getClient(int clientIndex) {
    final var clients = this.clientList;
    if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
