package pl.edu.mimuw;

import java.util.ArrayList;
import java.util.List;

public class BankClient {

    private final String id;
    private final String surname;
    private final String name;
    private final int age;
    private final List<BankAction> actionHistory = new ArrayList<>();
    private double balance;

    public BankClient(String name, String surname, int age, String id,
                      double balance) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
        this.balance = balance;
    }

    public boolean isProbablyAStudent() {
        return this.balance < 100;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getAge() {
        return this.age;
    }

    public String getCredentials() {
        return this.name + " " + this.surname + " (" + this.id + ")";
    }

    public double getBalance() {
        return this.balance;
    }

    public void subtractBalance(double amount) {
        this.balance -= amount;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public String getId() {
        return this.id;
    }

    public List<BankAction> getActionHistory() {
        return List.copyOf(actionHistory);
    }

    public void addAction(BankAction action) {
        this.actionHistory.add(action);
    }
}
