package matteogilioli.balancebuddy.controller.actions;

import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.model.Balance;
import matteogilioli.balancebuddy.view.table.BalanceTable;

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

