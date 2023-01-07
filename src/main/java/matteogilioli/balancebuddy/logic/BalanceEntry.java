package matteogilioli.balancebuddy.logic;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class BalanceEntry {
    private String description;
    private double amount;
    private LocalDateTime datetime;

    public BalanceEntry(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.datetime = LocalDateTime.now();
    }

    public BalanceEntry(String description, double amount, LocalDateTime datetime) {
        this.description = description;
        this.amount = amount;
        this.datetime = datetime;
    }

    public final String getDescription() {
        return description;
    }

    public final double getAmount() {
        return amount;
    }

    public final LocalDateTime getDatetime() {
        return datetime;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public final void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}



