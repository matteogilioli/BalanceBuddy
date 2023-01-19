package matteogilioli.balancebuddy.logic.actions.buttonsListener;

import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {
    private final BalanceTable table;

    public DeleteListener(BalanceTable table) {
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] selectedIndexes = table.getSelectedIndexes();
        Balance.removeEntries(selectedIndexes);
        ((BalanceTableModel) table.getModel()).refresh();
    }
}

