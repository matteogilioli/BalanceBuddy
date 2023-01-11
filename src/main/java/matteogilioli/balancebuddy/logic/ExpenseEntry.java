package matteogilioli.balancebuddy.logic;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public final class ExpenseEntry extends BalanceEntry {
    public ExpenseEntry(String description, BigDecimal amount) {
        super(description, amount.negate());
    }

    public ExpenseEntry(String description, BigDecimal amount, LocalDateTime datetime) {
        super(description, amount.negate(), datetime);
    }
}