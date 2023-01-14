package matteogilioli.balancebuddy.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class IncomeEntry extends BalanceEntry {
    public IncomeEntry(String description, BigDecimal amount, LocalDateTime datetime) {
        super(description, amount, datetime);
    }
}
