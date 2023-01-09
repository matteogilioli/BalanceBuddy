package matteogilioli.balancebuddy.logic;

import java.util.Date;

public final class IncomeEntry extends BalanceEntry {
    public IncomeEntry(String description, double amount) {
        super(description, amount);
    }
    public IncomeEntry(String description, double amount, Date datetime) {
        super(description, amount, datetime);
    }
}
