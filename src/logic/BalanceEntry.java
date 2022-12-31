package logic;

import java.time.LocalDateTime;

public abstract class BalanceEntry {
    private String description;
    private double amount;
    private LocalDateTime datetime;

    public BalanceEntry(String description, double amount) {
        this.datetime = LocalDateTime.now();
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}



