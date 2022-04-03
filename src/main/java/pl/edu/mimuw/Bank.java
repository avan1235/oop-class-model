package pl.edu.mimuw;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Bank {

  private final String bankName;

  private final List<BankClient> clients;

  private double totalMoneyDeposited;

  private double totalMoneyLoaned;

  public Bank(String bankName) {
    this.bankName = bankName;
    this.clients = new ArrayList<BankClient>();
    this.totalMoneyDeposited = 0;
    this.totalMoneyLoaned = 0;
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

    sb.append("Welcome in ").append(this.bankName).append("\n")
      .append("Number of clients in the bank: ").append(this.getNumberOfClients()).append("\n")
      .append("Money deposited in the bank: ").append(moneyDeposited).append("\n")
      .append("Money loaned from the bank: ").append(moneyLoaned).append("\n\n");

    this.getAllClients().stream()
      .sorted(Comparator.comparing(BankClient::getAccountNumber))
      .forEach(sb::append);

    return sb.toString();
  }

  public List<BankClient> getAllClients() {
    final var clients = new ArrayList<BankClient>();

    this.clients.stream().map(BankClient::new).forEach(clients::add);

    return clients;
  }

  public void addClient(BankClient client) {
    this.clients.add(client);
    this.addMoneyDeposited(client.getMoneyDeposited());
    this.addMoneyLoaned(client.getMoneyLoaned());
  }

  public int getNumberOfClients() {
    return this.clients.size();
  }

  /**
   * @return sum of all money deposited in the bank.
   */
  public double getMoneyDeposited() {
    return this.totalMoneyDeposited;
  }

  /**
   * @return sum of all money loaned from the bank.
   */
  public double getMoneyLoaned() {
    return this.totalMoneyLoaned;
  }

  /**
   * Adds a given amount of money to the total money deposited in the bank.
   *
   * @param money amount of money to be deposited.
   */
  public void addMoneyDeposited(double money) {
    this.totalMoneyDeposited += money;
  }

  /**
   * Adds a given amount of money to the total money loaned from the bank.
   *
   * @param money amount of money to be loaned.
   */
  public void addMoneyLoaned(double money) {
    this.totalMoneyLoaned += money;
  }

  public BankClient getClient(int clientIndex) {
    final var clients = getAllClients();
    if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
