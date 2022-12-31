package gui;

import gui.panels.TablePanel;
import logic.Balance;

import javax.swing.*;
import java.awt.*;

public class BudgetBuddyFrame extends JFrame {
    private final TablePanel tablePanel;
    private final Balance bl;

    public BudgetBuddyFrame(Balance bl) {
        super();

        this.bl = bl;

        this.setTitle("BudgetBuddy");
        this.setResizable(false);

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));

        this.add(Box.createVerticalStrut(4));

        tablePanel = new TablePanel(bl.getEntries());
        c.add(tablePanel);

        this.pack();
    }
}
