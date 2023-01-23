package matteogilioli.balancebuddy.logic.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Classe che rappresenta una specifica uscita del bilancio.
 */
public final class ExpenseEntry extends BalanceEntry {
    /**
     * Costruttore della classe.
     *
     * @param description il nome dell'uscita.
     * @param amount      l'importo dell'uscita (deve essere positivo), codificato in {@link BigDecimal}.
     * @param datetime    la data e ora dell'uscita, codificata in {@link LocalDateTime}.
     */
    public ExpenseEntry(String description, BigDecimal amount, LocalDateTime datetime) {
        super(description, amount, datetime);
    }

    /**
     * @return un oggetto {@link BigDecimal} con l'importo dell'uscita, sempre negativo.
     */
    @Override
    public BigDecimal getAmount() {
        return amount.negate();
    }
}