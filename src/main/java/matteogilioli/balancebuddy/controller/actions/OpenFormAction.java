package matteogilioli.balancebuddy.controller.actions;

import matteogilioli.balancebuddy.view.FormDialog;
import matteogilioli.balancebuddy.view.table.BalanceTable;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OpenFormAction extends AbstractAction {
    private final BalanceTable table;

    public OpenFormAction(String name, BalanceTable table) {
        super(name);
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Nuova Entrata")) {
            new FormDialog("Entrata", table);
        } else if (e.getActionCommand().equals("Nuova Uscita")) {
            new FormDialog("Uscita", table);
        }
    }
}
