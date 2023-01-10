package matteogilioli.balancebuddy.gui.components.buttons.listener;

import matteogilioli.balancebuddy.gui.panels.TablePanel;
import matteogilioli.balancebuddy.logic.Balance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {
    private final Balance balance;
    private final TablePanel tablePanel;

    public DeleteListener(Balance balance, TablePanel tablePanel) {
        this.balance = balance;
        this.tablePanel = tablePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] selectedIndexes = tablePanel.getTable().getSelectedIndexes();
        balance.removeEntries(selectedIndexes);
        tablePanel.updateTable();
    }
}

