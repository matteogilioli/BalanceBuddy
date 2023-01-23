package matteogilioli.balancebuddy.logic.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Classe che rappresenta una specifica entrata del bilancio.
 */
public final class IncomeEntry extends BalanceEntry {
    /**
     * Costruttore della classe.
     *
     * @param description il nome dell'entrata.
     * @param amount      l'importo dell'entrata (deve essere positivo), codificato in {@link BigDecimal}.
     * @param datetime    la data e ora dell'entrata, codificata in {@link LocalDateTime}.
     */
    public IncomeEntry(String description, BigDecimal amount, LocalDateTime datetime) {
        super(description, amount, datetime);
    }

    /**
     * @return un oggetto {@link BigDecimal} con l'importo dell'entrata, sempre positivo.
     */
    @Override
    public BigDecimal getAmount() {
        return amount;
    }
}
