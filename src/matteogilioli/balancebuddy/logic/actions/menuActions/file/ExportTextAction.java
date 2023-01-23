package matteogilioli.balancebuddy.logic.actions.menuActions.file;

import matteogilioli.balancebuddy.gui.MenuBar;
import matteogilioli.balancebuddy.logic.file.export.SaveText;
import matteogilioli.balancebuddy.gui.file.SaveFile;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Un'{@link AbstractAction} del {@link MenuBar Menubar} per i dati in formato testuale.
 */
public class ExportTextAction extends AbstractAction {
    /**
     * Oggetto {@link SaveFile} che si occupa di salvare un file.
     */
    private final SaveFile text;

    /**
     * Costruttore che inizializza l'{@link AbstractAction} con il nome nel {@link MenuBar Menubar},
     * inizializza {@link #text} con un oggetto {@link SaveText}, per salvare un file nel formato testuale.
     *
     * @param name il nome dell'{@link AbstractAction} nel {@link MenuBar Menubar}
     */
    public ExportTextAction(String name) {
        super(name);
        this.text = new SaveText();
    }

    /**
     * Chiama {@link SaveText#create()} per esportare i dati in un file di testo.
     *
     * @param e l'{@link ActionEvent} che ha generato l'azione
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        text.create();
    }
}