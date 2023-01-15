package matteogilioli.balancebuddy.view;

import matteogilioli.balancebuddy.controller.actions.OpenFormAction;
import matteogilioli.balancebuddy.view.table.BalanceTable;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(BalanceTable table) {
        super();

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("Apri"));
        fileMenu.add(new JMenuItem("Salva col nome..."));
        JMenu exportMenu = new JMenu("Esporta come...");
        exportMenu.add(new JMenuItem("File CSV"));
        exportMenu.add(new JMenuItem("File di testo"));
        fileMenu.addSeparator();
        fileMenu.add(exportMenu);

        JMenu addMenu = new JMenu("Aggiungi");
        addMenu.add(new JMenuItem(new OpenFormAction("Nuova Entrata", table)));
        addMenu.add(new JMenuItem(new OpenFormAction("Nuova Uscita", table)));

        this.add(fileMenu);
        this.add(addMenu);
    }
}
