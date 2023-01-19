package matteogilioli.balancebuddy.controller.menuActions.file;

import matteogilioli.balancebuddy.controller.file.backup.SaveBackup;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveAction extends AbstractAction {
    public SaveAction(String name) {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SaveBackup().create();
    }
}