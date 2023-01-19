package matteogilioli.balancebuddy.controller.file.export;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.controller.file.SaveFile;
import matteogilioli.balancebuddy.logic.file.ExportManager;
import matteogilioli.balancebuddy.logic.model.Balance;

import javax.swing.*;
import java.io.File;

public class SaveCSV extends SaveFile {
    public SaveCSV() {
        super("csv", "CSV");
    }

    protected boolean saveFile(File file) {
        String successMessage = "File CSV esportato con succcesso!";
        String errorMessage = "Errore durante l'esportazione del file CSV";

        if (new ExportManager().exportCSV(Balance.getEntries(), file)) {
            JOptionPane.showMessageDialog(Utility.getJFrame(), successMessage);
            return true;
        } else {
            JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage, "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}