package matteogilioli.balancebuddy.controller.file.backup;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.controller.file.LoadFile;
import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.logic.file.BackupManager;
import matteogilioli.balancebuddy.logic.model.Balance;

import javax.swing.*;
import java.io.File;

public class LoadBackup extends LoadFile {
    private final BalanceTableModel tableModel;

    public LoadBackup(JTable table) {
        super("balancebuddy", "Backup di BalanceBuddy");
        tableModel = (BalanceTableModel) table.getModel();
    }

    protected void loadFile(File file) {
        String successMessage = "Il bilancio è stato caricato con successo!";
        String errorMessage = "Errore durante il caricamento del bilancio";

        Object data = new BackupManager().load(file);
        if (data.getClass() == Balance.getEntries().getClass()) {
            Balance.setEntries(data);
            tableModel.refresh();
            setCompleted(true);
            JOptionPane.showMessageDialog(Utility.getJFrame(), successMessage);
        } else JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage, "Errore", JOptionPane.ERROR_MESSAGE);
    }
}
