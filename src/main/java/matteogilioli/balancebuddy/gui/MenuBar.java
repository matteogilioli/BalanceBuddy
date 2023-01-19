package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.controller.menuActions.PrintAction;
import matteogilioli.balancebuddy.controller.menuActions.add.NewExpenseAction;
import matteogilioli.balancebuddy.controller.menuActions.add.NewIncomeAction;
import matteogilioli.balancebuddy.controller.menuActions.file.ExportCSVAction;
import matteogilioli.balancebuddy.controller.menuActions.file.ExportTextAction;
import matteogilioli.balancebuddy.controller.menuActions.file.LoadAction;
import matteogilioli.balancebuddy.controller.menuActions.file.SaveAction;
import matteogilioli.balancebuddy.gui.table.BalanceTable;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(BalanceTable table) {
        super();

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem(new LoadAction("Apri...", table)));
        fileMenu.add(new JMenuItem(new SaveAction("Salva...")));
        JMenu exportMenu = new JMenu("Esporta come...");
        exportMenu.add(new JMenuItem(new ExportCSVAction("CSV")));
        exportMenu.add(new JMenuItem(new ExportTextAction("File di testo")));
        fileMenu.addSeparator();
        fileMenu.add(exportMenu);
        fileMenu.addSeparator();
        fileMenu.add(new JMenuItem(new PrintAction("Stampa", table)));

        JMenu addMenu = new JMenu("Aggiungi");
        addMenu.add(new JMenuItem(new NewIncomeAction("Nuova entrata", table)));
        addMenu.add(new JMenuItem(new NewExpenseAction("Nuova uscita", table)));

        this.add(fileMenu);
        this.add(addMenu);
    }
}
