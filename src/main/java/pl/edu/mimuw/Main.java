package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

  public static void main(String[] args) throws IOException {
    final var bank = new Bank("MIM UW Bank");

    // If we want to add a new client, all we need to do is add his name, surname, age and account number to this array.
    final BankClient[] clients = {
      new BankClient("Karol", "Wojtyla", 102, "213702042005"),
      new BankClient("Marcin", "Majkut", 25, "245694204502"),
      new BankClient("Mariusz", "Pudzian", 45, "450702197708"),
      new BankClient("Adam", "Malysz", 44, "323450702030")
    };

    Arrays.stream(clients).forEach(bank::addClient);
    Arrays.stream(clients).forEach(client -> addRandomActions(client, bank));

    System.out.println(bank);

    // This part was added to play with streams
    Arrays.stream(clients).max(Comparator.comparing(BankClient::getMoneyDeposited)).ifPresent(bankClient ->
      System.out.println("Client with the most money deposited: " + bankClient.getName() + " " + bankClient.getSurname()));

    Arrays.stream(clients).max(Comparator.comparing(BankClient::getMoneyLoaned)).ifPresent(bankClient ->
      System.out.println("Client with the most money loaned: " + bankClient.getName() + " " + bankClient.getSurname()));
  }

  /**
   * This method adds a couple of random actions to given client's action history.
   */
  private static void addRandomActions(BankClient client, Bank bank) {
    final var numberOfActions = new Random().nextInt(7) + 1;

    for (int i = 0; i < numberOfActions; i++) {
      final var action = new Random().nextBoolean();
      final var amount = new Random().nextDouble() * 10000;
      final var startYear = new Random().nextInt(10) + 2010;
      final var startMonth = new Random().nextInt(12) + 1;
      final var startDay = new Random().nextInt(28) + 1;
      var endYear = startYear + new Random().nextInt(10);
      final var endMonth = (startMonth + new Random().nextInt(12)) % 12 + 1;
      if (endMonth <= startMonth && endYear == startYear) {
        endYear++;
      }
      final var endDay = (startDay + new Random().nextInt(28)) % 28 + 1;
      final var startDate = Timestamp.valueOf(LocalDateTime.of(startYear, Month.of(startMonth), startDay,
        0, 0, 0));
      final var endDate = Timestamp.valueOf(LocalDateTime.of(endYear, Month.of(endMonth), endDay,
        0, 0, 0));

      if (action) {
        final var percent = new Random().nextInt(5) + 1;
        client.addAction(new DepositBankAction(amount, startDate, endDate, percent));
        client.addMoneyDeposited(amount);
        bank.addMoneyDeposited(amount);
      } else {
        final var rate = new Random().nextInt(10) + 5;
        client.addAction(new LoanBankAction(amount, startDate, endDate, rate));
        client.addMoneyLoaned(amount);
        bank.addMoneyLoaned(amount);
      }
    }
  }
}
