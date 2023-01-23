package matteogilioli.balancebuddy.logic.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Classe che rappresenta una specifica {@link IncomeEntry entrata} o {@link ExpenseEntry uscita} del bilancio.
 */
public abstract class BalanceEntry implements Serializable {
    /**
     * L'importo dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     * È sempre positivo, indipendentemente dal fatto che sia l'una o l'altra.
     */
    protected BigDecimal amount;
    /**
     * Il nome dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     */
    private String description;
    /**
     * La data e ora dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     */
    private LocalDateTime datetime;

    /**
     * Costruttore della classe.
     *
     * @param description il nome dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     * @param amount      l'importo dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita} (deve essere positivo).
     * @param datetime    la data e ora dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     */
    public BalanceEntry(String description, BigDecimal amount, LocalDateTime datetime) {
        this.description = description;
        this.amount = amount.abs();
        this.datetime = datetime;
    }

    /**
     * @return la data e ora dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     */
    public LocalDateTime getDatetime() {
        return datetime;
    }

    /**
     * Imposta la data e ora dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     *
     * @param datetime la nuova data e ora dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     */
    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime.truncatedTo(ChronoUnit.MINUTES);
    }

    /**
     * @return il nome dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Imposta il nome dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     *
     * @param description il nuovo nome dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return l'importo dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}, positivo indipendentemente dal fatto che sia l'una o l'altra.
     */
    public abstract BigDecimal getAmount();

    /**
     * Imposta l'importo dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     * L'importo viene sempre impostato positivo, indipendentemente dal fatto che sia l'una o l'altra.
     *
     * @param amount il nuovo importo dell'{@link IncomeEntry entrata} o {@link ExpenseEntry uscita}.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount.abs();
    }
}



