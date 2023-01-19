package matteogilioli.balancebuddy.controller.file.export;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.controller.file.SaveFile;
import matteogilioli.balancebuddy.logic.file.ExportManager;
import matteogilioli.balancebuddy.logic.model.Balance;

import javax.swing.*;
import java.io.File;

public class SaveText extends SaveFile {
    public SaveText() {
        super("txt", "File testuale");
    }

    protected boolean saveFile(File file) {
        String successMessage = "File testuale esportato con successo!";
        String errorMessage = "Errore durante l'esportazione del file testuale";

        if (new ExportManager().exportText(Balance.getEntries(), file)) {
            JOptionPane.showMessageDialog(Utility.getJFrame(), successMessage);
            return true;
        } else {
            JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage, "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}