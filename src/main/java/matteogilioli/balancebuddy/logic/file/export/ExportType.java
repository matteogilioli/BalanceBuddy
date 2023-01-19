package matteogilioli.balancebuddy.logic.file.export;

import matteogilioli.balancebuddy.logic.model.BalanceEntry;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class ExportType {
    private final String separator;

    public ExportType(String separator) {
        this.separator = separator;
    }

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
