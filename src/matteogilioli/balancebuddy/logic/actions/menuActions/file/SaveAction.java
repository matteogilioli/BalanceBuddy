package matteogilioli.balancebuddy.logic.actions.menuActions.file;

import matteogilioli.balancebuddy.gui.MenuBar;
import matteogilioli.balancebuddy.logic.file.backup.SaveBackup;
import matteogilioli.balancebuddy.gui.file.SaveFile;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Un'{@link AbstractAction} del {@link MenuBar Menubar} per salvare un backup.
 */
public class SaveAction extends AbstractAction {
    /**
     * Oggetto {@link SaveFile} che si occupa di salvare un file.
     */
    private final SaveFile backup;

    /**
     * Costruttore che inizializza l'{@link AbstractAction} con il nome nel {@link MenuBar Menubar},
     * inizializza {@link #backup} con un oggetto {@link SaveBackup}, per salvare un file nel formato di backup.
     *
     * @param name il nome dell'{@link AbstractAction} nel {@link MenuBar Menubar}
     */
    public SaveAction(String name) {
        super(name);
        this.backup = new SaveBackup();
    }

    /**
     * Chiama {@link SaveBackup#create()} per salvare un backup.
     *
     * @param e l'{@link ActionEvent} che ha generato l'azione
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        backup.create();
    }
}