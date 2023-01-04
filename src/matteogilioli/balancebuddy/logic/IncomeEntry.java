package matteogilioli.balancebuddy.logic;

import java.time.LocalDateTime;

public final class IncomeEntry extends BalanceEntry {
    public IncomeEntry(String description, double amount) {
        super(description, amount);
    }
    public IncomeEntry(String description, double amount, LocalDateTime datetime) {
        super(description, amount, datetime);
    }
}
