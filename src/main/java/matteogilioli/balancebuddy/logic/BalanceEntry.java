package matteogilioli.balancebuddy.logic;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class BalanceEntry {
    private String description;
    private BigDecimal amount;
    private LocalDateTime datetime;

    public BalanceEntry(String description, BigDecimal amount) {
        this.description = description;
        this.amount = amount;
        this.datetime = LocalDateTime.now();
    }

    public BalanceEntry(String description, BigDecimal amount, LocalDateTime datetime) {
        this.description = description;
        this.amount = amount;
        this.datetime = datetime;
    }

    public final String getDescription() {
        return description;
    }

    public final BigDecimal getAmount() {
        return amount;
    }

    public final LocalDateTime getDatetime() {
        return datetime;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public final void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}



