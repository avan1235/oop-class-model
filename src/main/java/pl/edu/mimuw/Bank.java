package pl.edu.mimuw;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Bank {

  private final List<BankClient> clients;

  public Bank() {
    this.clients = new ArrayList<BankClient>();
  }

  /**
   * @return string representation of the bank with clients sorted by their account numbers.
   */
  @Override
  public String toString() {
    final var sb = new StringBuilder();
    final var moneyDeposited = new BigDecimal(String.valueOf(this.getMoneyDeposited()))
      .setScale(2, RoundingMode.HALF_UP);
    final var moneyLoaned = new BigDecimal(String.valueOf(this.getMoneyLoaned()))
      .setScale(2, RoundingMode.HALF_UP);

    sb.append("Number of clients in the bank: ").append(this.getNumberOfClients()).append("\n");
    sb.append("Money deposited in the bank: ").append(moneyDeposited).append("\n");
    sb.append("Money loaned from the bank: ").append(moneyLoaned).append("\n\n");

    final var clientsList = this.getAllClients();
    clientsList.stream()
      .sorted(Comparator.comparing(BankClient::getAccountNumber))
      .forEach(sb::append);

    return sb.toString();
  }

  public List<BankClient> getAllClients() {
    final var clients = new ArrayList<BankClient>();

    for (var client : this.clients) {
      clients.add(new BankClient(client));
    }

    return clients;
  }

  public void addClient(BankClient client) {
    this.clients.add(client);
  }

  public int getNumberOfClients() {
    return this.clients.size();
  }

  /**
   * @return sum of all money deposited in the bank.
   */
  public double getMoneyDeposited() {
    double money = 0;

    for (var client : this.getAllClients()) {
      money += client.getMoneyDeposited();
    }

    return money;
  }

  /**
   * @return sum of all money loaned from the bank.
   */
  public double getMoneyLoaned() {
    double money = 0;

    for (var client : this.getAllClients()) {
      money += client.getMoneyLoaned();
    }

    return money;
  }

  public BankClient getClient(int clientIndex) {
    final var clients = getAllClients();
    if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
