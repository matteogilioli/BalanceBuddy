package matteogilioli.balancebuddy.logic.file.backup;

import matteogilioli.balancebuddy.logic.file.model.LoadFile;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadBackup extends LoadFile {
    public LoadBackup(BalanceTableModel tableModel) {
        super("balancebuddy", "Backup di BalanceBuddy", tableModel);
    }

    @Override
    public Object load(File file) {
        try {
            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            Object data = objectStream.readObject();
            objectStream.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            return new Error();
        }
    }
}
