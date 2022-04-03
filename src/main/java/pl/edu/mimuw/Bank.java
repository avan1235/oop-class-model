package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private final String bankName;
  private final String city;
  private final ArrayList<BankClient> clients;

  public Bank(String bankName, String city) {
    this.bankName = bankName;
    this.city = city;
    clients = new ArrayList<BankClient>();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(this.bankName);
    sb.append(" in ");
    sb.append(this.city);
    sb.append("\nlist of clients: \n");
    for (var v : clients) {
      sb.append(v.getName());
      sb.append(" ");
      sb.append(v.getSurname());
      sb.append("\n");
    }
    return sb.toString();
  }

  public List<BankClient> getAllClients() {
    ArrayList<BankClient> copy = new ArrayList<>();
    copy.addAll(clients);
    return copy;
  }

  public void addClient(BankClient client) {
    clients.add(client);
  }

  public BankClient getClient(int clientIndex) {
    final var clients = getAllClients();
    if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
