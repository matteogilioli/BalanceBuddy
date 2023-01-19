package matteogilioli.balancebuddy.logic.actions.menuActions.file;

import matteogilioli.balancebuddy.logic.file.backup.LoadBackup;
import matteogilioli.balancebuddy.logic.file.model.LoadFile;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;

public class LoadAction extends AbstractAction {
    private final LoadFile backup;

    public LoadAction(String name, TableModel tableModel) {
        super(name);
        this.backup = new LoadBackup((BalanceTableModel) tableModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        backup.create();
    }
}