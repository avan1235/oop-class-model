package pl.edu.mimuw;

import java.util.List;

public class Bank {

    @Override
    public String toString() {
        throw new IllegalStateException("TODO: get information about bank and all its clients (use StringBuilder)");
    }

    public List<BankClient> getAllClients() {
        throw new IllegalStateException("TODO: remember not to return internal state list as it can be modified");
    }

    public void addClient(BankClient client) {
        throw new IllegalStateException("TODO");
    }

    public BankClient getClient(int clientIndex) {
        final var clients = getAllClients();
        if (clientIndex >= clients.size()) throw new IllegalArgumentException("Invalid client index");
        return clients.get(clientIndex);
    }
}
