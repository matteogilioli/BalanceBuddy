package matteogilioli.balancebuddy.controller.file;

import matteogilioli.balancebuddy.controller.Utility;

import javax.swing.*;
import java.io.File;

public abstract class LoadFile extends FileController {
    public LoadFile(String extensionName, String extensionDescription) {
        super(extensionName, extensionDescription);
    }

    public void loadingOrSaving(File file, boolean extensionIsCorrect) {
        String errorMessage1 = "Il file selezionato non è un ." + getExtensionName();
        String errorMessage2 = "Il file selezionato non esiste";

        if (file.exists()) {
            if (extensionIsCorrect) {
               loadFile(file);
            } else JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage1, "Errore", JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage2, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    protected int dialogFunction(JFrame frame) {
        return getFileChooser().showOpenDialog(frame);
    }

    protected abstract void loadFile(File file);
}
