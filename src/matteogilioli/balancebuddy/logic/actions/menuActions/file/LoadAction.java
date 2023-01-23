package matteogilioli.balancebuddy.logic.actions.menuActions.file;

import matteogilioli.balancebuddy.gui.MenuBar;
import matteogilioli.balancebuddy.logic.file.backup.LoadBackup;
import matteogilioli.balancebuddy.gui.file.LoadFile;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;

/**
 * Un'{@link AbstractAction} del {@link MenuBar Menubar} per caricare un backup.
 */
public class LoadAction extends AbstractAction {
    /**
     * Oggetto {@link LoadFile} che si occupa di caricare un file.
     */
    private final LoadFile backup;

    /**
     * Costruttore che inizializza l'{@link AbstractAction} con il nome nel {@link MenuBar Menubar},
     * inizializza {@link #backup} con un oggetto {@link LoadBackup}, per caricare un file.
     *
     * @param name il nome dell'{@link AbstractAction} nel {@link MenuBar Menubar}
     * @param tableModel il {@link TableModel} della tabella
     */
    public LoadAction(String name, TableModel tableModel) {
        super(name);
        this.backup = new LoadBackup((BalanceTableModel) tableModel);
    }

    /**
     * Chiama {@link LoadBackup#create()} per caricare un backup.
     *
     * @param e l'{@link ActionEvent} che ha generato l'azione
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        backup.create();
    }
}