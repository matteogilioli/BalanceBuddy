package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.gui.components.panels.LeftPanel;
import matteogilioli.balancebuddy.gui.components.panels.TablePanel;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.awt.*;

public final class BudgetBuddyFrame extends JFrame {
    private final JPanel tablePanel;
    private final JPanel leftPanel;
    private final Balance balance;

    public BudgetBuddyFrame(Balance balance) {
        super();

        this.balance = balance;

        tablePanel = new TablePanel(balance);
        leftPanel = new LeftPanel(balance, (TablePanel) tablePanel);

        this.setTitle("BalanceBuddy");

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(20));

        JPanel main = new JPanel(new GridBagLayout());
        main.add(Box.createHorizontalStrut(30));
        main.add(leftPanel);
        main.add(Box.createHorizontalStrut(20));
        main.add(tablePanel);
        main.add(Box.createHorizontalStrut(20));
        this.add(main);

        this.add(Box.createVerticalStrut(20));
        this.pack();

        this.pack();
        this.setMinimumSize(this.getSize());
    }
}
