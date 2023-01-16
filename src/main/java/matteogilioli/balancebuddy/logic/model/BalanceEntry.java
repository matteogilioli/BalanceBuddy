package matteogilioli.balancebuddy.logic.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class BalanceEntry implements Serializable {
    private String description;
    protected BigDecimal amount;
    private LocalDateTime datetime;

    public BalanceEntry(String description, BigDecimal amount, LocalDateTime datetime) {
        this.description = description;
        this.amount = amount;
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public abstract BigDecimal getAmount();

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}



