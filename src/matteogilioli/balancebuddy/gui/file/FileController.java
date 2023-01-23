package matteogilioli.balancebuddy.gui.file;

import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * Gestisce la logica di selezione di un file (caricamento o salvataggio).
 */
public abstract class FileController {
    /**
     * Il {@link JFileChooser} utilizzato per la selezione del file.
     */
    private final JFileChooser fileChooser;

    /**
     * L'estensione dei file da visualizzare nel {@link #fileChooser}.
     */
    private final String extensionName;

    /**
     * Il nome del file che verrà visualizzato di default nel {@link #fileChooser}.
     */
    private String defaultFileName;

    /**
     * Tiene traccia se l'operazione di caricamento o salvataggio è stata completata.
     */
    private boolean completed;

    /**
     * Costruttore, inizializza il {@link #fileChooser} e imposta l'estensione dei file da visualizzare.
     *
     * @param extensionName        L'estensione dei file da visualizzare nel {@link #fileChooser}.
     * @param extensionDescription La descrizione dell'estensione dei file da visualizzare nel {@link #fileChooser}.
     */
    public FileController(String extensionName, String extensionDescription) {
        this.extensionName = extensionName;
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(extensionDescription, extensionName));
        fileChooser.setAcceptAllFileFilterUsed(false);
        defaultFileName = "";
    }

    /**
     * Mostra il {@link #fileChooser}, se l'utente seleziona un file controlla se l'estensione del
     * file selezionato è corretta (basandosi su {@link #extensionName}), successivamente chiama il
     * metodo {@link #loadingOrSaving(File, boolean)} per procedere con il caricamento o il salvataggio.
     */
    public void create() {
        File defaultFile = new File(defaultFileName);

        completed = false;
        while (!completed) {
            fileChooser.setSelectedFile(defaultFile);
            int userSelection = dialogFunction();
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                boolean extensionIsCorrect = FilenameUtils.getExtension(file.getName()).equals(extensionName);
                loadingOrSaving(file, extensionIsCorrect);
            } else if (userSelection == JFileChooser.CANCEL_OPTION) completed = true;
        }
    }

    /**
     * Modifica {@link #completed} per indicargli se il salvataggio o il caricamento è stato completato, oppure se l'utente ha annullato l'operazione.
     *
     * @param completed true se l'operazione è stata completata, false se l'utente ha annullato l'operazione
     */
    protected void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * @return {@link #fileChooser}.
     */
    protected JFileChooser getFileChooser() {
        return fileChooser;
    }

    /**
     * @return {@link #extensionName}.
     */
    protected String getExtensionName() {
        return extensionName;
    }

    /**
     * Imposta {@link #defaultFileName} con il nome del file passato come parametro.
     *
     * @param defaultFileName il nome del file che verrà visualizzato di default nel {@link #fileChooser}
     */
    protected void setDefaultFileName(String defaultFileName) {
        this.defaultFileName = defaultFileName;
    }

    /**
     * Metodo astratto che deve essere implementato dalle sottoclassi, viene chiamato dopo la selezione del file.
     * Il metodo implementato deve procedere ai dialoghi specifici per il caricamento o il salvataggio.
     *
     * @param file               il file selezionato
     * @param extensionIsCorrect true se l'estensione del file selezionato è corretta, false altrimenti.
     */
    protected abstract void loadingOrSaving(File file, boolean extensionIsCorrect);

    /**
     * Metodo astratto che deve essere implementato dalle sottoclassi, che dovranno chiamare
     * {@link JFileChooser#showOpenDialog(Component)} o {@link JFileChooser#showSaveDialog(Component)}.
     *
     * @return lo stato di ritorno del metodo chiamato.
     */
    protected abstract int dialogFunction();
}