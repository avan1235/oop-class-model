package pl.edu.mimuw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome in MIM UW Bank");
    final var bank = new Bank();

    // If we want to add a new client, all we need to do is add his name, surname, age and account number to this array.
    final BankClient[] clients = {
      new BankClient("Karol", "Wojtyla", 102, "213702042005"),
      new BankClient("Marcin", "Majkut", 25, "245694204502"),
      new BankClient("Mariusz", "Pudzian", 45, "450702197708"),
      new BankClient("Adam", "Malysz", 44, "323450702030")
    };

    final var clientsList = Arrays.asList(clients);

    clientsList.stream().forEach(bank::addClient);
    clientsList.stream().forEach(BankClient::addRandomActions);

    System.out.println(bank);

    // This part was added to play with streams
    final var clientMostDeposited = clientsList.stream().max(Comparator.comparing(BankClient::getMoneyDeposited));
    clientMostDeposited.ifPresent(bankClient -> System.out.println("Client with the most money deposited: "
      + bankClient.getName() + " " + bankClient.getSurname()));

    final var clientMostLoaned = clientsList.stream().max(Comparator.comparing(BankClient::getMoneyLoaned));
    clientMostLoaned.ifPresent(bankClient -> System.out.println("Client with the most money loaned: "
      + bankClient.getName() + " " + bankClient.getSurname()));
  }
}
