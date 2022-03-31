package pl.edu.mimuw;

import java.io.IOException;

import java.sql.Timestamp;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome in MIM UW Bank");
		final var bank = new Bank();
		
		BankClient papiez = new BankClient("Karol", "Wojtyla", 101, "2137", 420);
		bank.addClient(papiez);
		papiez.withdraw(69);
		papiez.birthday();
		
		BankClient student = new BankClient("Dominik", "Wawszczak", 20, "123456", 0);
		student.addAction(new LoanBankAction(1024, Timestamp.valueOf("2022-03-31 21:37:00"), Timestamp.valueOf("2022-10-31 21:37:00"), 32));
		
		System.out.println(bank);
	}
}