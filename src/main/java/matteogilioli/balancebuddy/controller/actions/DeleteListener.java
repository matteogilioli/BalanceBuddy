package matteogilioli.balancebuddy.controller.actions;

import matteogilioli.balancebuddy.controller.Application;
import matteogilioli.balancebuddy.view.panels.TablePanel;
import matteogilioli.balancebuddy.model.Balance;

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

