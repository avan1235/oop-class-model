package pl.edu.mimuw;

import java.sql.Timestamp;

public abstract class BankAction {

    public double totalAmount() {
        throw new IllegalStateException("TODO");
    }

    public Timestamp getStartTimestamp() {
        throw new IllegalStateException("TODO");
    }

    public Timestamp getEndTimestamp() {
        throw new IllegalStateException("TODO");
    }

    @Override
    public abstract String toString();
}
