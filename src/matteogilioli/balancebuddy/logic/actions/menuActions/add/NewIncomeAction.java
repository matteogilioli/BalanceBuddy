package matteogilioli.balancebuddy.logic.actions.menuActions.add;

import matteogilioli.balancebuddy.gui.FormDialog;
import matteogilioli.balancebuddy.gui.MenuBar;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;

/**
 * Un'{@link AbstractAction} del {@link MenuBar Menubar} per aggiungere un'entrata.
 */
public class NewIncomeAction extends AbstractAction {
    /**
     * Oggetto {@link BalanceTableModel} che dovrà essere aggiornato, una volta aggiunta l'entrata.
     */
    private final BalanceTableModel tableModel;

    /**
     * Costruttore che inizializza l'{@link AbstractAction} con il nome nel {@link MenuBar Menubar},
     * inizializza {@link #tableModel} con il {@link BalanceTableModel} della tabella.
     *
     * @param name il nome dell'{@link AbstractAction} nel {@link MenuBar Menubar}
     * @param tableModel il {@link TableModel} della tabella
     */
    public NewIncomeAction(String name, BalanceTableModel tableModel) {
        super(name);
        this.tableModel = tableModel;
    }

    /**
     * Crea un {@link FormDialog} per aggiungere un'entrata.
     *
     * @param e l'{@link ActionEvent} che ha generato l'azione
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new FormDialog("Entrata", tableModel);
    }
}
