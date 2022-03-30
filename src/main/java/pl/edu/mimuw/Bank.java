package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
  private final ArrayList<BankClient> clients;

  public Bank() {
    clients = new ArrayList<>();
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder("Bank with clients:\n");
    for(var client : clients){
      res.append(client.toString());
      res.append(",\n");
    }
    return res.toString();
  }

  public String newAccountNumber(){
    return "" + new Random().nextInt();
  }

  public List<BankClient> getAllClients() {
    ArrayList<BankClient> res = new ArrayList<>();
    for(var client : clients)
      res.add(new BankClient(client));
    return res;
  }

  public void addClient(BankClient client) {
    this.clients.add(client);
  }

  public BankClient getClient(int clientIndex) {
    final var clients = getAllClients();
    if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
