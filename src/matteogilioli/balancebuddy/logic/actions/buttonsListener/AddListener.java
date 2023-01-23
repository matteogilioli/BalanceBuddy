package matteogilioli.balancebuddy.logic.actions.buttonsListener;

import matteogilioli.balancebuddy.gui.FormDialog;
import matteogilioli.balancebuddy.gui.components.AddButton;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import matteogilioli.balancebuddy.logic.model.ExpenseEntry;
import matteogilioli.balancebuddy.logic.model.IncomeEntry;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;

/**
 * L'{@link ActionListener} di {@link AddButton}, che recupera i campi immessi e
 * aggiunge un nuovo movimento al {@link Balance}.
 */
public class AddListener implements ActionListener {
    /**
     * Il {@link FormDialog} che contiene i campi da aggiungere.
     */
    private final FormDialog form;

    /**
     * Il {@link BalanceTableModel} che dovrà essere aggiornato, una volta aggiunto il movimento.
     */
    private final BalanceTableModel tableModel;

    /**
     * Costruttore che inizializza {@link #form} e {@link #tableModel}.
     *
     * @param form il {@link FormDialog} che contiene i campi da aggiungere
     * @param tableModel il {@link BalanceTableModel} della tabella
     */
    public AddListener(FormDialog form, BalanceTableModel tableModel) {
        this.form = form;
        this.tableModel = tableModel;
    }

    /**
     * Recupera i campi seguenti da {@link #form}:
     * <ul>
     *     <li>Tipo</li>
     *     <li>Descrizione</li>
     *     <li>Importo</li>
     *     <li>Data e ora</li>
     * </ul>
     *
     * Se i campi sono stati tutti inseriti correttamente, aggiunge un nuovo movimento:
     * <ul>
     *     <li>Se il tipo è "Entrata", aggiunge un'{@link IncomeEntry} al {@link Balance}.</li>
     *     <li>Se il tipo è "Uscita", aggiunge un'{@link ExpenseEntry} al {@link Balance}.</li>
     * </ul>
     * Successivamente aggiorna il {@link BalanceTableModel} per riflettere le modifiche.
     *
     * @param e l'{@link ActionEvent} che ha generato l'azione
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String type = form.getSelectedType();
        String description = form.getDescription();
        String amountString = form.getAmount();
        LocalDateTime datetime = form.getDatetime();

        if (description.isBlank() && amountString.isBlank())
            form.setError("Descrizione ed importo mancanti");
        else if (description.isBlank())
            form.setError("Descrizione mancante");
        else if (amountString.isBlank())
            form.setError("Importo mancante");
        if (description.isBlank() || amountString.isBlank())
            return;

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        BigDecimal amount;
        try {
            amount = new BigDecimal(nf.parse(amountString).toString());
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }

        BalanceEntry entry = switch (type) {
            case "Entrata" -> new IncomeEntry(description, amount, datetime);
            case "Uscita" -> new ExpenseEntry(description, amount, datetime);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };

        form.dispose();
        Balance.setEntry(entry);
        tableModel.refresh();
    }
}
