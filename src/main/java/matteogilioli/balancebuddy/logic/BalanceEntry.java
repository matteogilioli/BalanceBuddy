package matteogilioli.balancebuddy.logic;

import java.math.BigDecimal;
import java.util.Date;

public abstract class BalanceEntry {
    private String description;
    private BigDecimal amount;
    private Date datetime;

    public BalanceEntry(String description, BigDecimal amount) {
        this.description = description;
        this.amount = amount;
        this.datetime = new Date();
    }

    public BalanceEntry(String description, BigDecimal amount, Date datetime) {
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

    public final Date getDatetime() {
        return datetime;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public final void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}



