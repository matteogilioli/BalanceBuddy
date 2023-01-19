package matteogilioli.balancebuddy.controller.menuActions.file;

import matteogilioli.balancebuddy.controller.file.backup.LoadBackup;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoadAction extends AbstractAction {
    private final JTable table;

    public LoadAction(String name, JTable table) {
        super(name);
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new LoadBackup(table).create();
    }
}