package matteogilioli.balancebuddy.logic.file.export;

import matteogilioli.balancebuddy.logic.model.BalanceEntry;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Si occupa di esportare i dati in un file di testo, separando i campi con un separatore.
 */
public class ExportWithSeparator {
    /**
     * Il separatore da usare per separare i campi.
     */
    private final String separator;

    /**
     * Costruttore che inizializza {@link #separator} con il separatore passato come parametro.
     *
     * @param separator il separatore da usare per separare i campi
     */
    public ExportWithSeparator(String separator) {
        this.separator = separator;
    }

    /**
     * Scrive le entrate passate come parametro in un file di testo, separando i campi con il
     * separatore inizializzato nel costruttore.
     *
     * @param entries le entrate da salvare
     * @param file    il file in cui salvare le entrate
     * @return true se il salvataggio è andato a buon fine, false altrimenti
     */
    public boolean export(ArrayList<BalanceEntry> entries, File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Data" + separator + "Orario" + separator + "Descrizione" + separator + "Importo");
            for (BalanceEntry entry : entries) {
                String date = entry.getDatetime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String time = entry.getDatetime().format(DateTimeFormatter.ofPattern("HH:mm"));
                String description = entry.getDescription();
                String amount = String.format(Locale.US, "%.2f", entry.getAmount());
                writer.println(date + separator + time + separator + description + separator + amount);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
