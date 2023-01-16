package matteogilioli.balancebuddy.controller.menuActions;

import matteogilioli.balancebuddy.gui.FormDialog;
import matteogilioli.balancebuddy.gui.table.BalanceTable;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewExpenseAction extends AbstractAction {
    private final BalanceTable table;

    public NewExpenseAction(String name, BalanceTable table) {
        super(name);
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new FormDialog("Uscita", table);
    }
}
