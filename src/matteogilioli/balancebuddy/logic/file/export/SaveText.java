package matteogilioli.balancebuddy.logic.file.export;

import matteogilioli.balancebuddy.gui.file.SaveFile;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;

import java.io.File;
import java.util.ArrayList;

/**
 * Utilizza {@link SaveFile} e {@link ExportWithSeparator} per salvare i dati in formato testuale.
 */
public class SaveText extends SaveFile {
    /**
     * L'oggetto {@link ExportWithSeparator} che si occupa di effettivamente salvare i dati.
     */
    private final ExportWithSeparator text;

    /**
     * Costruttore che chiama il costruttore della superclasse {@link SaveFile} passandogli
     * l'estensione del file e la descrizione. Inizializza {@link #text} con il separatore
     * utilizzato nel formato testuale (tabulazione).
     */
    public SaveText() {
        super("txt", "File testuale");
        text = new ExportWithSeparator("\t");
    }

    /**
     * Chiama il metodo {@link ExportWithSeparator#export} dell'oggetto {@link #text}
     * inizializzato nel costruttore.
     *
     * @param entries le entrate da salvare
     * @param file    il file in cui salvare le entrate
     * @return true se il salvataggio è andato a buon fine, false altrimenti
     */
    @Override
    public boolean saveFile(ArrayList<BalanceEntry> entries, File file) {
        return text.export(entries, file);
    }
}