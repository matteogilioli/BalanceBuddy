package gui;

import gui.panels.BudgetTablePanel;
import logic.VoceBilancio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BudgetBuddyFrame extends JFrame {
    private final BudgetTablePanel tablePanel;
    private final ArrayList<VoceBilancio> voci;

    public BudgetBuddyFrame(ArrayList<VoceBilancio> voci) {
        super();

        this.voci = voci;

        this.setTitle("BudgetBuddy");
        this.setResizable(false);

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));

        this.add(Box.createVerticalStrut(4));

        tablePanel = new BudgetTablePanel(voci);
        c.add(tablePanel);

        this.pack();
    }
}
