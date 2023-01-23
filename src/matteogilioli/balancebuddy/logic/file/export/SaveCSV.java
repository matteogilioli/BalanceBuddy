package matteogilioli.balancebuddy.logic.file.export;

import matteogilioli.balancebuddy.gui.file.SaveFile;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;

import java.io.File;
import java.util.ArrayList;

/**
 * Utilizza {@link SaveFile} e {@link ExportWithSeparator} per salvare i dati in formato CSV.
 */
public class SaveCSV extends SaveFile {
    /**
     * L'oggetto {@link ExportWithSeparator} che si occupa di effettivamente salvare i dati.
     */
    private final ExportWithSeparator csv;

    /**
     * Costruttore che chiama il costruttore della superclasse {@link SaveFile} passandogli
     * l'estensione del file e la descrizione. Inizializza {@link #csv} con il separatore
     * utilizzato nel formato testuale (virgola).
     */
    public SaveCSV() {
        super("csv", "CSV");
        csv = new ExportWithSeparator(",");
    }

    /**
     * Chiama il metodo {@link ExportWithSeparator#export} dell'oggetto {@link #csv}
     * inizializzato nel costruttore.
     *
     * @param entries le entrate da salvare
     * @param file    il file in cui salvare le entrate
     * @return true se il salvataggio è andato a buon fine, false altrimenti
     */
    @Override
    public boolean saveFile(ArrayList<BalanceEntry> entries, File file) {
        return csv.export(entries, file);
    }
}