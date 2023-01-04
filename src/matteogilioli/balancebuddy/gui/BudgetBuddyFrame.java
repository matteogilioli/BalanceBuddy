package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.gui.panels.FormPanel;
import matteogilioli.balancebuddy.gui.panels.TableButtonsPanel;
import matteogilioli.balancebuddy.gui.components.TablePanel;
import matteogilioli.balancebuddy.logic.Balance;
import matteogilioli.balancebuddy.logic.BalanceEntry;
import matteogilioli.balancebuddy.logic.ExpenseEntry;
import matteogilioli.balancebuddy.logic.IncomeEntry;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;

public final class BudgetBuddyFrame extends JFrame {
    private final TablePanel table;
    private final TableButtonsPanel tableButtonsPanel;
    private final FormPanel form;
    private final Balance balance;

    public BudgetBuddyFrame(Balance balance) {
        super();

        this.balance = balance;

        table = new TablePanel(balance.getEntries());

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
                String description = form.getDescription();
                double amount = form.getAmount();
                LocalDateTime datetime = form.getDatetime();

                BalanceEntry entry = switch (form.getType()) {
                    case "Entrata" -> new IncomeEntry(description, amount, datetime);
                    case "Uscita" -> new ExpenseEntry(description, amount, datetime);
                    default -> throw new IllegalStateException("Unexpected value: " + form.getType());
                };

                form.clear();
                balance.addEntry(entry);
                table.updateTable();
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
