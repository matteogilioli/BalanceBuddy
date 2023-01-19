package matteogilioli.balancebuddy.logic.actions.menuActions.add;

import matteogilioli.balancebuddy.gui.FormDialog;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;

public class NewExpenseAction extends AbstractAction {
    private final TableModel tableModel;

    public NewExpenseAction(String name, TableModel tableModel) {
        super(name);
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new FormDialog("Uscita", tableModel);
    }
}
