package matteogilioli.balancebuddy.logic.file.model;

import matteogilioli.balancebuddy.logic.Utility;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public abstract class LoadFile extends FileController {
    private final BalanceTableModel tableModel;

    public LoadFile(String extensionName, String extensionDescription, BalanceTableModel tableModel) {
        super(extensionName, extensionDescription);
        this.tableModel = tableModel;
    }

    @Override
    public void loadingOrSaving(File file, boolean extensionIsCorrect) {
        String errorMessage1 = "Il file selezionato non è un ." + getExtensionName();
        String errorMessage2 = "Il file selezionato non esiste";

        if (file.exists()) {
            if (extensionIsCorrect) {
               loadFile(file);
            } else JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage1, "Errore", JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage2, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    private void loadFile(File file) {
        String successMessage = "Il file " + file.getName() + " è stato caricato correttamente!";
        String errorMessage = "Errore durante il caricamento del file " + file.getName();

        ArrayList<BalanceEntry> data = readFromFile(file);
        if (data != null) {
            Balance.setEntries(data);
            tableModel.refresh();
            setCompleted(true);
            JOptionPane.showMessageDialog(Utility.getJFrame(), successMessage);
        } else JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    protected int dialogFunction(JFrame frame) {
        return getFileChooser().showOpenDialog(frame);
    }

    public abstract ArrayList<BalanceEntry> readFromFile(File file);
}
