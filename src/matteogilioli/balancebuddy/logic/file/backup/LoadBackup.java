package matteogilioli.balancebuddy.logic.file.backup;

import matteogilioli.balancebuddy.gui.file.LoadFile;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Si occupa di caricare i dati da un file binario.
 */
public class LoadBackup extends LoadFile {

    /**
     * Costruttore che chiama il costruttore della superclasse {@link LoadFile} passandogli come parametri
     * l'estensione del file, la descrizione e il {@link BalanceTableModel} da aggiornare.
     *
     * @param tableModel il {@link BalanceTableModel} da aggiornare
     */
    public LoadBackup(BalanceTableModel tableModel) {
        super("balancebuddy", "Backup di BalanceBuddy", tableModel);
    }

    /**
     * Carica le entrate da un file binario, controllando che l'oggetto letto sia valido.
     *
     * @param file il file da cui caricare le entrate
     * @return true se il caricamento è andato a buon fine, false altrimenti
     */
    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<BalanceEntry> loadFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(file);
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);
        ArrayList<?> data = (ArrayList<?>) objectStream.readObject();
        objectStream.close();
        for (Object entry : data) {
            if (!(entry instanceof BalanceEntry))
                throw new IOException();
        }
        return (ArrayList<BalanceEntry>) data;
    }
}
