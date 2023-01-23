package matteogilioli.balancebuddy.logic.actions.buttonsListener;

import matteogilioli.balancebuddy.gui.components.DeleteButton;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * L'{@link ActionListener} di {@link DeleteButton}, che in base alla selezione della tabella,
 * elimina i movimenti selezionati.
 */
public class DeleteListener implements ActionListener {
    /**
     * La {@link BalanceTable} dalla quale recuperare la selezione.
     */
    private final BalanceTable table;

    /**
     * Il {@link BalanceTableModel} che dovrà essere aggiornato, una volta eliminati i movimenti.
     * @param table la {@link BalanceTable} dalla quale recuperare la selezione
     */
    public DeleteListener(BalanceTable table) {
        this.table = table;
    }

    /**
     * Recupera la selezione della tabella ed elimina i movimenti selezionati.
     * Aggiorna il {@link BalanceTableModel} della tabella per riflettere le modifiche.
     *
     * @param e l'{@link ActionEvent} che ha scatenato l'{@link ActionListener}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int[] selectedIndexes = table.getSelectedIndexes();
        Balance.removeEntries(selectedIndexes);
        (table.getModel()).refresh();
    }
}

