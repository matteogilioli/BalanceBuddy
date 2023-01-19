package matteogilioli.balancebuddy.logic.actions.menuActions.file;

import matteogilioli.balancebuddy.logic.file.backup.SaveBackup;
import matteogilioli.balancebuddy.logic.file.model.SaveFile;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveAction extends AbstractAction {
    private final SaveFile backup;

    public SaveAction(String name) {
        super(name);
        this.backup = new SaveBackup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        backup.create();
    }
}