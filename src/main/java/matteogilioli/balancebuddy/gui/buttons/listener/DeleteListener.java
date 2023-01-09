package matteogilioli.balancebuddy.gui.buttons.listener;

import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.Balance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {
    private final Balance balance;
    private final BalanceTable table;

    public DeleteListener(Balance balance, BalanceTable table) {
        this.balance = balance;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] selectedIndexes = table.getSelectedIndexes();
        balance.removeEntries(selectedIndexes);
        table.updateTable();
    }
}

