package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  final private ArrayList<BankClient> BankClients;
  final private String name;

  public Bank(String name) {
    this.name = name;
    this.BankClients = new ArrayList<>();
  }

  @Override
  public String toString() {
    final StringBuilder String = new StringBuilder("Bank " + this.name + "{");
    String.append("\nClients:\n").append(this.getAllClients());
    String.append("}");

    return String.toString();
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
