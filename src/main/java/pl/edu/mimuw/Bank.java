package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private double allMoney;
  private List<BankClient> bankClients;

  public Bank(double allMoney, List<BankClient> bankClients)
  {
    this.allMoney = allMoney;
    this.bankClients = bankClients;
  }

  @Override
  public String toString()
  {
    StringBuilder s = new StringBuilder();
    s.append("---------------\n\nall money in bank: ").append(allMoney);
    for(BankClient i : bankClients)
    {
      s.append("\n\n---------------\n\nname: ").append(i.getName()).append("\n");
      s.append("surname: ").append(i.getSurname()).append("\n");
      s.append("age: ").append(i.getAge()).append("\n");
      s.append("account number: ").append(i.getAccountNumber()).append("\n");
      s.append("money: ").append(i.getMoney()).append("\n\n");
      s.append("actions:\n");
      for(BankAction j : i.getActionHistory())
      {
        s.append(("bank action: ")).append(j.toString()).append("\n");
      }
      s.append("\n---------------");
    }
    return s.toString();
  }

  public List<BankClient> getAllClients()
  {
    List<BankClient> c = new ArrayList<>();

    for(BankClient a : bankClients)
    {
      c.add(a);
    }

    return c;
  }

  public void addClient(BankClient client)
  {
    bankClients.add(client);
  }

  public BankClient getClient(int clientIndex) {
    final var clients = getAllClients();
    if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
    return clients.get(clientIndex);
  }
}
