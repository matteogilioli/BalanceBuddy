package matteogilioli.balancebuddy.controller.buttonsListener;

import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.model.Balance;

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

