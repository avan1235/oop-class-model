package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private ArrayList<BankClient> clients;

  public Bank() {
    this.clients = new ArrayList<>();
  }

  @Override
  public String toString() {

    var sb = new StringBuilder();
    sb.append("**************************\n");
    sb.append("All clients number: ").append(clients.size()).append("\n");
    int allActions = 0;
    int allMoney = 0;
    for (var client : clients) {
      allActions += client.getActionNumber();
      allMoney += client.getMoney();
    }
    sb.append("How many actions: ").append(allActions).append("\n");
    sb.append("How much stored money: ").append(allMoney).append("\n");
    sb.append("\nActions and money of each client: \n");
    int index = 0;
    for (var client : clients) {
      index++;
      sb.append("Client ").append(client.getName()).append(" ").append(client.getSurname());
      sb.append(" has : ").append(client.getActionNumber()).append(" actions and ");
      sb.append(client.getMoney()).append(" money \n");
    }
    sb.append("**************************");
    return sb.toString();
  }

  public List<BankClient> getAllClients() {
    List<BankClient> result = new ArrayList<BankClient>();
    for (var client : clients) {
      String name = client.getName();
      String surname = client.getSurname();
      int age = client.getAge();
      int money = client.getMoney();
      String accountNumber = client.getAccountNumber();
      List<BankAction> actionHistory = client.getActionHistory();
      result.add(new BankClient(name, surname, age, money, accountNumber, actionHistory));
    }
    return result;

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
