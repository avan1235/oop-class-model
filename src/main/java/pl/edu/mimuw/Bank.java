package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {

  private List<BankClient> allClients;
  private String name;
  private String slogan;
  private int numberOfClients;

  public Bank(String name, String slogan) {
    this.name = name;
    this.slogan = slogan;
    this.allClients = new ArrayList<>();
    numberOfClients = 0;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name);
    sb.append("\n");
    sb.append(slogan);
    sb.append("\n");
    if (numberOfClients == 0) {
      return sb.toString();
    } else {
      sb.append("KLIENCI:" + "\n");
      for (int i = 0; i < numberOfClients; i++) {
        sb.append(allClients.get(i).toString());
        sb.append("\n");
      }
      return sb.toString();
    }
  }

  /**
   * @return Wazne - zwraca kopie listy wszystkich klientow wypelniona kopiami tychze
   */
  public List<BankClient> getAllClients() {
    if (allClients == null) {
      return null;
    }
    List<BankClient> overview = new ArrayList<>();
    for (int i = 0; i < allClients.size(); i++) {
      overview.add(allClients.get(i).createCopy());
    }
    return overview;
  }

  public void addClient(BankClient client) {
    allClients.add(client);
    numberOfClients++;
  }

  public void addActionForClient(BankAction action, int clientIndex) {
    if (clientIndex >= allClients.size()) throw new IllegalArgumentException(
      "Invalid client index"
    );
    allClients.get(clientIndex).addAction(action);
  }

  /**
   * @param amount - klient wplaca jakas kwote, by pozwracac dlugi
   * @return - jesli cos pozostalo po splacaniu, zwraca te kwote
   */
  public double repaymentByClient(double amount, int clientIndex) {
    if (clientIndex >= allClients.size()) throw new IllegalArgumentException(
      "Invalid client index"
    );
    return allClients.get(clientIndex).repayDebt(amount);
  }

  /**
   * @return zwraca pieniadze uzyskane z akcji liquidateHalfDeposits()
   */
  public double liquidationByClient(int clientIndex) {
    if (clientIndex >= allClients.size()) throw new IllegalArgumentException(
      "Invalid client index"
    );
    return allClients.get(clientIndex).liqudiateHalfDeposits();
  }

  /**
   * @return zwraca kopie klienta
   */
  public BankClient getClient(int clientIndex) {
    var clients = getAllClients();
    if (clientIndex >= clients.size()) throw new IllegalArgumentException(
      "Invalid client index"
    );
    return clients.get(clientIndex);
  }
}
