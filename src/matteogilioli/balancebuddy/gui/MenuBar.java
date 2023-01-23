package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.actions.menuActions.PrintAction;
import matteogilioli.balancebuddy.logic.actions.menuActions.add.NewExpenseAction;
import matteogilioli.balancebuddy.logic.actions.menuActions.add.NewIncomeAction;
import matteogilioli.balancebuddy.logic.actions.menuActions.file.ExportCSVAction;
import matteogilioli.balancebuddy.logic.actions.menuActions.file.ExportTextAction;
import matteogilioli.balancebuddy.logic.actions.menuActions.file.LoadAction;
import matteogilioli.balancebuddy.logic.actions.menuActions.file.SaveAction;

import javax.swing.*;

/**
 * La barra dei menu.
 */
public class MenuBar extends JMenuBar {

    /**
     * Costruttore che crea la barra dei menu.
     *
     * @param table la tabella, utilizzata per aggiornarla se necessario
     */
    public MenuBar(BalanceTable table) {
        super();

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem(new LoadAction("Apri...", table.getModel())));
        fileMenu.add(new JMenuItem(new SaveAction("Salva...")));
        JMenu exportMenu = new JMenu("Esporta come...");
        exportMenu.add(new JMenuItem(new ExportCSVAction("CSV")));
        exportMenu.add(new JMenuItem(new ExportTextAction("File di testo")));
        fileMenu.addSeparator();
        fileMenu.add(exportMenu);
        fileMenu.addSeparator();
        fileMenu.add(new JMenuItem(new PrintAction("Stampa", table)));

        JMenu addMenu = new JMenu("Aggiungi");
        addMenu.add(new JMenuItem(new NewIncomeAction("Nuova entrata", table.getModel())));
        addMenu.add(new JMenuItem(new NewExpenseAction("Nuova uscita", table.getModel())));

        this.add(fileMenu);
        this.add(addMenu);
    }
}
