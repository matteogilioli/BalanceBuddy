package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.gui.components.CreateDialog;
import matteogilioli.balancebuddy.gui.panels.ButtonsPanel;
import matteogilioli.balancebuddy.gui.panels.TablePanel;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class BudgetBuddyFrame extends JFrame {
    private final TablePanel tablePanel;
    private final Balance balance;

    public BudgetBuddyFrame(Balance balance) {
        super();

        this.balance = balance;

        this.setTitle("BudgetBuddy");
        this.setResizable(false);

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));

        this.add(Box.createVerticalStrut(4));

        tablePanel = new TablePanel(balance.getEntries());
        c.add(tablePanel);

        ActionListener deleteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedIndexes = tablePanel.getSelectedIndexes();
                balance.removeEntries(selectedIndexes);
                tablePanel.updateTable();
            }
        };

        ActionListener addListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateDialog();
            }
        };

        ButtonsPanel buttonRow = new ButtonsPanel(deleteListener, addListener);
        this.add(buttonRow);

        this.pack();
    }
}
