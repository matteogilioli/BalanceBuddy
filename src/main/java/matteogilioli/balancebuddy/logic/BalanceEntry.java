package matteogilioli.balancebuddy.logic;

import java.util.Date;

public abstract class BalanceEntry {
    private String description;
    private double amount;
    private Date datetime;

    public BalanceEntry(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.datetime = new Date();
    }

    public BalanceEntry(String description, double amount, Date datetime) {
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

    public final Date getDatetime() {
        return datetime;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public final void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}



