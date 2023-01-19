package matteogilioli.balancebuddy.controller.file;

import matteogilioli.balancebuddy.controller.Utility;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Override
    protected int dialogFunction(JFrame frame) {
        return getFileChooser().showSaveDialog(frame);
    }

    protected abstract boolean saveFile(File file);
}