package matteogilioli.balancebuddy.logic;

import java.time.LocalDateTime;

public final class ExpenseEntry extends BalanceEntry {
    public ExpenseEntry(String description, double amount) {
        super(description, -amount);
    }
    public ExpenseEntry(String description, double amount, LocalDateTime datetime) {
        super(description, -amount, datetime);
    }

    @Override
    public void setAmount(double amount) {
        super.setAmount(-amount);
    }
}