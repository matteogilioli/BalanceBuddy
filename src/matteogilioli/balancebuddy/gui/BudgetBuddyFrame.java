package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.gui.panels.FormPanel;
import matteogilioli.balancebuddy.gui.panels.TableButtonsPanel;
import matteogilioli.balancebuddy.gui.panels.Table;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class BudgetBuddyFrame extends JFrame {
    private final Table table;
    private final TableButtonsPanel tableButtonsPanel;
    private final FormPanel form;
    private final Balance balance;

    public BudgetBuddyFrame(Balance balance) {
        super();

        this.balance = balance;

        table = new Table(balance.getEntries());

        ActionListener deleteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedIndexes = table.getSelectedIndexes();
                balance.removeEntries(selectedIndexes);
                table.updateTable();
            }
        };
        ActionListener editListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        ActionListener addListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        form = new FormPanel(addListener);
        tableButtonsPanel = new TableButtonsPanel(table, deleteListener, editListener);

        this.setTitle("BudgetBuddy");
        this.setResizable(false);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        this.add(Box.createHorizontalStrut(30));
        this.add(form);
        this.add(Box.createHorizontalStrut(20));
        this.add(tableButtonsPanel);
        this.pack();
    }
}
