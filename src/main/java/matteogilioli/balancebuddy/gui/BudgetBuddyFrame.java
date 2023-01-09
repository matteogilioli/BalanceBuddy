package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.gui.panels.FormPanel;
import matteogilioli.balancebuddy.gui.panels.TableButtonsPanel;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;

public final class BudgetBuddyFrame extends JFrame {
    private final TableButtonsPanel tableButtonsPanel;
    private final FormPanel formPanel;
    private final Balance balance;

    public BudgetBuddyFrame(Balance balance) {
        super();

        this.balance = balance;

        tableButtonsPanel = new TableButtonsPanel(balance);
        formPanel = new FormPanel(balance, tableButtonsPanel.getTable());

        this.setTitle("BalanceBuddy");
        this.setResizable(false);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        this.add(Box.createHorizontalStrut(30));
        this.add(formPanel);
        this.add(Box.createHorizontalStrut(20));
        this.add(tableButtonsPanel);
        this.pack();
    }
}
