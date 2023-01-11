package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.gui.panels.FormPanel;
import matteogilioli.balancebuddy.gui.panels.TablePanel;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.awt.*;

public final class BudgetBuddyFrame extends JFrame {
    private final TablePanel tablePanel;
    private final FormPanel formPanel;
    private final Balance balance;

    public BudgetBuddyFrame(Balance balance) {
        super();

        this.balance = balance;

        tablePanel = new TablePanel(balance);
        formPanel = new FormPanel(balance, tablePanel);

        this.setTitle("BalanceBuddy");

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(20));

        JPanel main = new JPanel(new GridBagLayout());
        main.add(Box.createHorizontalStrut(20));
        main.add(formPanel);
        main.add(tablePanel);
        main.add(Box.createHorizontalStrut(20));
        this.add(main);

        this.add(Box.createVerticalStrut(20));
        this.pack();

        this.pack();
        this.setMinimumSize(this.getSize());
    }
}
