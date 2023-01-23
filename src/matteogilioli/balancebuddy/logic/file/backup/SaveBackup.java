package matteogilioli.balancebuddy.logic.file.backup;

import matteogilioli.balancebuddy.gui.file.SaveFile;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Si occupa di esportare i dati in un file binario.
 */
public class SaveBackup extends SaveFile {
    /**
     * Costruttore che chiama il costruttore della superclasse {@link SaveFile} passandogli come parametri
     * l'estensione del file e la descrizione.
     */
    public SaveBackup() {
        super("balancebuddy", "Backup di BalanceBuddy");
    }

    /**
     * Salva le entrate in un file binario.
     *
     * @param entries le entrate da salvare
     * @param file    il file in cui salvare le entrate
     * @return true se il salvataggio è andato a buon fine, false altrimenti
     */
    @Override
    public boolean saveFile(ArrayList<BalanceEntry> entries, File file) {
        try {
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(entries);
            objectStream.flush();
            objectStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

