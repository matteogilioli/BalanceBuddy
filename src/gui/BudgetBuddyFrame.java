package gui;

import gui.panels.BudgetTablePanel;
import logic.Bilancio;

import javax.swing.*;
import java.awt.*;

public class BudgetBuddyFrame extends JFrame {
    private final BudgetTablePanel tablePanel;
    private final Bilancio bl;

    public BudgetBuddyFrame(Bilancio bl) {
        super();

        this.bl = bl;

        this.setTitle("BudgetBuddy");
        this.setResizable(false);

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));

        this.add(Box.createVerticalStrut(4));

        tablePanel = new BudgetTablePanel(bl.getVoci());
        c.add(tablePanel);


        this.pack();
    }
}
