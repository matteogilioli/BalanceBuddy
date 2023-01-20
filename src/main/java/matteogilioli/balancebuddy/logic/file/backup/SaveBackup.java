package matteogilioli.balancebuddy.logic.file.backup;

import matteogilioli.balancebuddy.logic.file.model.SaveFile;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveBackup extends SaveFile {
    public SaveBackup() {
        super("balancebuddy", "Backup di BalanceBuddy");
    }

    @Override
    public boolean saveFromFile(ArrayList<BalanceEntry> data, File file) {
        try {
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(data);
            objectStream.flush();
            objectStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

