package matteogilioli.balancebuddy.logic.file.export;

import matteogilioli.balancebuddy.logic.file.model.SaveFile;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;

import java.io.File;
import java.util.ArrayList;

public class SaveText extends SaveFile {
    private final ExportType text = new ExportType("\t");

    public SaveText() {
        super("txt", "File testuale");
    }

    public boolean save(ArrayList<BalanceEntry> data, File file) {
        return text.export(data, file);
    }
}