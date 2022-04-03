package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		System.out.println("Welcome to MIM UW Bank\n");
		final var bank = new Bank("MIM UW Bank", "Poland", "Warsaw", "WMIMPLPW");

		bank.addClient(new BankClient("Karl", "Gauss", 42, "n(n-1)/2", "EUR")); //o dlatego na przykład dobrze byłoby, żeby numer konta był typem liczbowym
		bank.addClient(new BankClient("Simon-Pierre", "Laplace", -1, "\\sqrt{-1}", "USD")); //a wiek unsigned
		bank.addClient(new BankClient("Leonhard", "Euler", 33, "2.7182818284590452", "CHF"));
		bank.addClient(new BankClient("Archimedes", "", 75, "3.1415926535897932384626433832795028841939937510", "RUB"));
		bank.addClient(new BankClient("Carl", "Weierstrass", 53, "144", "GBP"));
		bank.addClient(new BankClient("Bernhard", "Riemann", 29, "0.5", "EUR"));
		bank.addClient(new BankClient("Stefan", "Banach", 2, "5540", "PLN"));

		bank.getClient(0).addAction(new DepositBankAction(200.0, "EUR", Timestamp.from(Instant.now()), new Timestamp(Timestamp.from(Instant.now()).getNanos() + 365L * 86400L * 1000L), 0.02));
		bank.getClient(4).addAction(new LoanBankAction(20000.0, "GBP", Timestamp.from(Instant.now()), new Timestamp(Timestamp.from(Instant.now()).getNanos() + 30L * 365L * 86400L * 1000L), 100.0));

		bank.getAllClients().stream().forEach(client -> client.addAction(new LoanBankAction(1e10, "AUD", Timestamp.from(Instant.now()),
				new Timestamp(Timestamp.from(Instant.now()).getNanos() + 5L * 365L * 86400L * 1000L), 10000.0)));

		System.out.println(bank);
	}
}
