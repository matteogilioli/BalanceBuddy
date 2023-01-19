package matteogilioli.balancebuddy.controller.file.backup;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.controller.file.SaveFile;
import matteogilioli.balancebuddy.logic.file.BackupManager;
import matteogilioli.balancebuddy.logic.model.Balance;

import javax.swing.*;
import java.io.File;

public class SaveBackup extends SaveFile {
    public SaveBackup() {
        super("balancebuddy", "Backup di BalanceBuddy");
    }

    protected boolean saveFile(File file) {
        String successMessage = "Backup salvato con successo";
        String errorMessage = "Errore durante il salvataggio del backup";

        if (new BackupManager().save(Balance.getEntries(), file)) {
            JOptionPane.showMessageDialog(Utility.getJFrame(), successMessage);
            return true;
        } else {
            JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage, "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}