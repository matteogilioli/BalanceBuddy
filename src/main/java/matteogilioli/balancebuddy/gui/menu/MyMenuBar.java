package matteogilioli.balancebuddy.gui.menu;

import javax.swing.*;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar() {
        super();

        JMenu menuAdd = new JMenu("Aggiungi");
        JMenuItem addIncome = new JMenuItem(new OpenFormAction("Nuova Entrata"));
        JMenuItem addExpense = new JMenuItem(new OpenFormAction("Nuova Uscita"));

        menuAdd.add(addIncome);
        menuAdd.add(addExpense);

        this.add(menuAdd);
    }
}
