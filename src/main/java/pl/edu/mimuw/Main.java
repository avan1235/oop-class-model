package pl.edu.mimuw;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome in MIM UW Bank");
        final var bank = new Bank(0.001, 0.2);

        Timestamp today = Timestamp.valueOf(java.time.LocalDateTime.now());

        final var jan = bank.openClientAccount("Jan", "Wąż", 20, 1000);
        final var grzegorz = bank.openClientAccount("Grzegorz", "Czołg", 25,
                7000);
        final var maria = bank.openClientAccount("Maria", "Wiatrak", 21, 2500);

        Calendar date = Calendar.getInstance();
        date.setTime(today);
        date.add(Calendar.DATE, 30);
        Timestamp future = Timestamp.from(date.toInstant());

        bank.applyForLoan(jan, 10, future);
        bank.applyForDeposit(grzegorz, 1000, future, 4);
        bank.applyForLoan(maria, 1000, future);

        bank.collectInstallments();

        while (!jan.isProbablyAStudent()) {
            bank.applyForLoan(jan, 50, Timestamp.from(date.toInstant()));
            bank.applyForDeposit(jan, 1000, Timestamp.from(date.toInstant()),
                    1);
            date.add(Calendar.DATE, 30);
            bank.advanceCurrentDate(30);
            bank.collectInstallments();
        }

        bank.collectInstallments();

        System.out.println(bank);
    }
}
