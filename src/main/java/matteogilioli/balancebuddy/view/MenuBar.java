package matteogilioli.balancebuddy.view;

import matteogilioli.balancebuddy.controller.actions.OpenFormAction;
import matteogilioli.balancebuddy.view.table.BalanceTable;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar(BalanceTable table) {
        super();

        JMenu menuAdd = new JMenu("Aggiungi");
        JMenuItem addIncome = new JMenuItem(new OpenFormAction("Nuova Entrata", table));
        JMenuItem addExpense = new JMenuItem(new OpenFormAction("Nuova Uscita", table));

        menuAdd.add(addIncome);
        menuAdd.add(addExpense);

        this.add(menuAdd);
    }
}
