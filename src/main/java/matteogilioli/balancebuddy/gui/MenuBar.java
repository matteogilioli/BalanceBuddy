package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.controller.menuActions.LoadAction;
import matteogilioli.balancebuddy.controller.menuActions.NewExpenseAction;
import matteogilioli.balancebuddy.controller.menuActions.NewIncomeAction;
import matteogilioli.balancebuddy.controller.menuActions.SaveAction;
import matteogilioli.balancebuddy.gui.table.BalanceTable;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(BalanceTable table) {
        super();

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem(new LoadAction("Apri...", table)));
        fileMenu.add(new JMenuItem(new SaveAction("Salva...")));
        JMenu exportMenu = new JMenu("Esporta come...");
        exportMenu.add(new JMenuItem("File CSV"));
        exportMenu.add(new JMenuItem("File di testo"));
        fileMenu.addSeparator();
        fileMenu.add(exportMenu);

        JMenu addMenu = new JMenu("Aggiungi");
        addMenu.add(new JMenuItem(new NewIncomeAction("Nuova entrata", table)));
        addMenu.add(new JMenuItem(new NewExpenseAction("Nuova uscita", table)));

        this.add(fileMenu);
        this.add(addMenu);
    }
}
