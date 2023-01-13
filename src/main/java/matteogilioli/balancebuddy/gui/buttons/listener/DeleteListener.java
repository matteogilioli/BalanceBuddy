package matteogilioli.balancebuddy.gui.buttons.listener;

import matteogilioli.balancebuddy.gui.Application;
import matteogilioli.balancebuddy.gui.window.TablePanel;
import matteogilioli.balancebuddy.logic.Balance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {
    private final TablePanel tablePanel;

    public DeleteListener(TablePanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] selectedIndexes = tablePanel.getTable().getSelectedIndexes();
        Balance.removeEntries(selectedIndexes);
        Application.refreshData();
    }
}

