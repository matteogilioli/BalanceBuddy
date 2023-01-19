package matteogilioli.balancebuddy.logic.file.export;

import matteogilioli.balancebuddy.logic.file.model.SaveFile;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;

import java.io.File;
import java.util.ArrayList;

public class SaveCSV extends SaveFile {
    private final ExportType csv = new ExportType(",");

    public SaveCSV() {
        super("csv", "CSV");
    }

    public boolean save(ArrayList<BalanceEntry> data, File file) {
        return csv.export(data, file);
    }
}