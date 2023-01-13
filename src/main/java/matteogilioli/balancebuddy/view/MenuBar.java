package matteogilioli.balancebuddy.view;

import matteogilioli.balancebuddy.controller.actions.OpenFormAction;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        super();

        JMenu menuAdd = new JMenu("Aggiungi");
        JMenuItem addIncome = new JMenuItem(new OpenFormAction("Nuova Entrata"));
        JMenuItem addExpense = new JMenuItem(new OpenFormAction("Nuova Uscita"));

        menuAdd.add(addIncome);
        menuAdd.add(addExpense);

        this.add(menuAdd);
    }
}
