package matteogilioli.balancebuddy.logic.file.backup;

import matteogilioli.balancebuddy.logic.file.model.LoadFile;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoadBackup extends LoadFile {
    public LoadBackup(BalanceTableModel tableModel) {
        super("balancebuddy", "Backup di BalanceBuddy", tableModel);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<BalanceEntry> readFromFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(file);
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);
        ArrayList<?> data = (ArrayList<?>) objectStream.readObject();
        objectStream.close();
        for (Object entry : data)
            if (!(entry instanceof BalanceEntry))
                throw new IOException();
        return (ArrayList<BalanceEntry>) data;
    }
}
