package matteogilioli.balancebuddy.logic.actions.menuActions.file;

import matteogilioli.balancebuddy.gui.MenuBar;
import matteogilioli.balancebuddy.logic.file.export.SaveCSV;
import matteogilioli.balancebuddy.logic.file.export.SaveText;
import matteogilioli.balancebuddy.gui.file.SaveFile;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Un'{@link AbstractAction} del {@link MenuBar Menubar} per esportare i dati in formato CSV.
 */
public class ExportCSVAction extends AbstractAction {
    /**
     * Oggetto {@link SaveFile} che si occupa di salvare un file.
     */
    private final SaveFile csv;

    /**
     * Costruttore che inizializza l'{@link AbstractAction} con il nome nel {@link MenuBar Menubar},
     * inizializza {@link #csv} con un oggetto {@link SaveCSV}, per salvare un file nel formato testuale.
     *
     * @param name il nome dell'{@link AbstractAction} nel {@link MenuBar Menubar}
     */
    public ExportCSVAction(String name) {
        super(name);
        this.csv = new SaveCSV();
    }

    /**
     * Chiama {@link SaveText#create()} per esportare i dati in un file di testo.
     *
     * @param e l'{@link ActionEvent} che ha generato l'azione
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        csv.create();
    }
}