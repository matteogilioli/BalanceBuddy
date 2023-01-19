package matteogilioli.balancebuddy.logic.file;

import matteogilioli.balancebuddy.logic.model.BalanceEntry;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class ExportManager {
    private boolean export(ArrayList<BalanceEntry> entries, File file, String separator) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Data" + separator + "Orario" + separator + "Descrizione" + separator + "Importo");
            for (BalanceEntry entry : entries) {
                String date = entry.getDatetime().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
                String time = entry.getDatetime().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
                String description = entry.getDescription();
                String amount = entry.getAmount().toString();
                writer.println(date + separator + time + separator + description + separator + amount);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean exportCSV(ArrayList<BalanceEntry> entries, File file) {
        return export(entries, file, ",");
    }

    public boolean exportText(ArrayList<BalanceEntry> entries, File file) {
        return export(entries, file, "\t");
    }
}
