package matteogilioli.balancebuddy.gui.file;

import matteogilioli.balancebuddy.logic.Utility;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Sottoclasse di {@link FileController} per gestire nello specifico il caricamento di un file.
 */
public abstract class LoadFile extends FileController {
    /**
     * Il {@link BalanceTableModel} per aggiornare la tabella, una volta caricato il file.
     */
    private final BalanceTableModel tableModel;

    /**
     * Costruttore della classe, passa al costruttore della superclasse il nome dell'estensione e
     * la sua descrizione. Inizializza {@link #tableModel} con il {@link BalanceTableModel} passato come parametro.
     *
     * @param extensionName        nome dell'estensione dei file da visualizzare nel {@link JFileChooser}
     * @param extensionDescription descrizione dell'estensione dei file da visualizzare nel {@link JFileChooser}
     * @param tableModel           il {@link BalanceTableModel} per aggiornare la tabella, una volta caricato il file
     */
    public LoadFile(String extensionName, String extensionDescription, BalanceTableModel tableModel) {
        super(extensionName, extensionDescription);
        this.tableModel = tableModel;
    }

    /**
     * Viene chiamato quando l'utente seleziona un file. Mostra messaggi di errore se il file selezionato
     * non esiste o se l'estensione del file non è corretta. Successivamente chiama il metodo
     * {@link #loadDialog(File)} per procedere con il caricamento.
     *
     * @param file               il file selezionato
     * @param extensionIsCorrect true se l'estensione del file selezionato è corretta, false altrimenti.
     */
    @Override
    public void loadingOrSaving(File file, boolean extensionIsCorrect) {
        String errorMessage1 = "Il file selezionato non è un ." + getExtensionName();
        String errorMessage2 = "Il file selezionato non esiste";

        if (file.exists()) {
            if (extensionIsCorrect) {
                loadDialog(file);
            } else
                JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage1, "Errore", JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage2, "Errore", JOptionPane.ERROR_MESSAGE);
    }


    /**
     * Chiama il metodo {@link #loadFile(File)} per caricare il file, poi aggiorna la tabella e
     * mostra un messaggio di successo o di errore.
     *
     * @param file il file selezionato
     */
    private void loadDialog(File file) {
        String successMessage = "Il file " + file.getName() + " è stato caricato correttamente!";
        String errorMessage = "Errore durante il caricamento del file " + file.getName();

        try {
            ArrayList<BalanceEntry> data = loadFile(file);
            Balance.setEntries(data);
            tableModel.refresh();
            setCompleted(true);
            JOptionPane.showMessageDialog(Utility.getJFrame(), successMessage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage, "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Utilizza {@link JFileChooser#showOpenDialog(Component)} per mostrare il dialogo per aprire un file.
     */
    @Override
    protected int dialogFunction() {
        return getFileChooser().showOpenDialog(Utility.getJFrame());
    }

    /**
     * Metodo astratto che deve essere implementato dalle sottoclassi per leggere il file.
     *
     * @param file il file da leggere
     * @return un {@link ArrayList} di {@link BalanceEntry} contenente i dati letti dal file
     * @throws IOException            se si verifica un errore durante la lettura del file
     * @throws ClassNotFoundException se si verifica un errore durante la lettura del file
     */
    public abstract ArrayList<BalanceEntry> loadFile(File file) throws IOException, ClassNotFoundException;
}
