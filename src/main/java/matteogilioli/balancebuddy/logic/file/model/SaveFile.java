package matteogilioli.balancebuddy.logic.file.model;

import matteogilioli.balancebuddy.logic.Utility;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class SaveFile extends FileController {
    public SaveFile(String extensionName, String extensionDescription) {
        super(extensionName, extensionDescription);
        LocalDateTime now = LocalDateTime.now();
        String defaultFileName = "Backup " + now.format(DateTimeFormatter.ofPattern("dd-MM-yy HH-mm-ss")) + "." + getExtensionName();
        setDefaultFileName(defaultFileName);
    }

    @Override
    protected void loadingOrSaving(File file, boolean extensionIsCorrect) {
        String overwriteQuestion = "Il file esiste già, vuoi sovrascriverlo?";
        String overwriteTitle = "File già esistente";

        if (!extensionIsCorrect)
            file = new File(FilenameUtils.removeExtension(file.getName()) + "." + getExtensionName());
        if (file.exists()) {
            int overwrite = JOptionPane.showConfirmDialog(Utility.getJFrame(), overwriteQuestion, overwriteTitle, JOptionPane.YES_NO_OPTION);
            setCompleted(overwrite == JOptionPane.YES_OPTION && saveFile(file));
        } else setCompleted(saveFile(file));
    }

    private boolean saveFile(File file) {
        String successMessage = "Il file " + file.getName() + " è stato salvato correttamente!";
        String errorMessage = "Errore durante l'esportazione del file " + file.getName();

        if (save(Balance.getEntries(), file)) {
            JOptionPane.showMessageDialog(Utility.getJFrame(), successMessage);
            return true;
        } else {
            JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage, "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    protected int dialogFunction(JFrame frame) {
        return getFileChooser().showSaveDialog(frame);
    }

    public abstract boolean save(ArrayList<BalanceEntry> data, File file);
}