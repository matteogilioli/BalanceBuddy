package matteogilioli.balancebuddy.logic;

import java.math.BigDecimal;
import java.util.Date;

public final class ExpenseEntry extends BalanceEntry {
    public ExpenseEntry(String description, BigDecimal amount) {
        super(description, amount.negate());
    }

    public ExpenseEntry(String description, BigDecimal amount, Date datetime) {
        super(description, amount.negate(), datetime);
    }
}