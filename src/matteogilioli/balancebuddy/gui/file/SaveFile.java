package matteogilioli.balancebuddy.gui.file;

import matteogilioli.balancebuddy.logic.Utility;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Sottoclasse di {@link FileController} per gestire nello specifico il salvataggio di un file.
 */
public abstract class SaveFile extends FileController {

    /**
     * Costruttore della classe, passa al costruttore della superclasse il nome dell'estensione e
     * la sua descrizione. Crea un nome di default basato sulla data e ora corrente per il file da salvare, e
     * lo passa a {@link #setDefaultFileName(String)} per impostarlo come nome di default.
     *
     * @param extensionName        nome dell'estensione dei file da visualizzare nel {@link JFileChooser}
     * @param extensionDescription descrizione dell'estensione dei file da visualizzare nel {@link JFileChooser}
     */
    public SaveFile(String extensionName, String extensionDescription) {
        super(extensionName, extensionDescription);
        LocalDateTime now = LocalDateTime.now();
        String defaultFileName = "Backup " + now.format(DateTimeFormatter.ofPattern("dd-MM-yy HH-mm-ss")) + "." + getExtensionName();
        setDefaultFileName(defaultFileName);
    }

    /**
     * Viene chiamato quando l'utente seleziona un file. Se l'estensione del file non è corretta, viene aggiunta.
     * Successivamente controlla se il file esiste già, e se esiste chiede all'utente se vuole sovrascriverlo.
     * Chiama il metodo {@link #saveDialog(File)} per procedere con il salvataggio.
     *
     * @param file               il file selezionato
     * @param extensionIsCorrect true se l'estensione del file selezionato è corretta, false altrimenti
     */
    @Override
    protected void loadingOrSaving(File file, boolean extensionIsCorrect) {
        String overwriteQuestion = "Il file esiste già, vuoi sovrascriverlo?";
        String overwriteTitle = "File già esistente";

        if (!extensionIsCorrect)
            file = new File(FilenameUtils.removeExtension(file.getName()) + "." + getExtensionName());
        if (file.exists()) {
            int overwrite = JOptionPane.showConfirmDialog(Utility.getJFrame(), overwriteQuestion, overwriteTitle, JOptionPane.YES_NO_OPTION);
            setCompleted(overwrite == JOptionPane.YES_OPTION && saveDialog(file));
        } else setCompleted(saveDialog(file));
    }

    /**
     * Chiama il metodo {@link #saveFile(ArrayList, File)} per salvare il file, poi
     * mostra un messaggio di successo o di errore, a seconda del risultato.
     *
     * @param file il file selezionato
     * @return true se il salvataggio è andato a buon fine, false altrimenti
     */
    private boolean saveDialog(File file) {
        String successMessage = "Il file " + file.getName() + " è stato salvato correttamente!";
        String errorMessage = "Errore durante l'esportazione del file " + file.getName();

        if (saveFile(Balance.getEntries(), file)) {
            JOptionPane.showMessageDialog(Utility.getJFrame(), successMessage);
            return true;
        } else {
            JOptionPane.showMessageDialog(Utility.getJFrame(), errorMessage, "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Utilizza {@link JFileChooser#showSaveDialog(Component)} per mostrare il dialogo per salvare un file.
     */
    @Override
    protected int dialogFunction() {
        return getFileChooser().showSaveDialog(Utility.getJFrame());
    }

    /**
     * Metodo astratto che deve essere implementato dalle sottoclassi per salvare il file.
     *
     * @param entries lista di {@link BalanceEntry} da salvare
     * @param file    il file selezionato
     * @return true se il salvataggio è andato a buon fine, false altrimenti
     */
    public abstract boolean saveFile(ArrayList<BalanceEntry> entries, File file);
}