package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.buttons.DeleteButton;
import matteogilioli.balancebuddy.gui.listener.DeleteListener;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.gui.table.BalanceTableModel;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;

public class TableButtonsPanel extends JPanel {
    private final BalanceTableModel tableModel;
    private final BalanceTable table;
    private final JScrollPane tableScrollPane;
    private final DeleteButton deleteButton;

    public TableButtonsPanel(Balance balance) {
        super();

        tableModel = new BalanceTableModel(balance.getEntries());
        table = new BalanceTable(tableModel);
        tableScrollPane = new JScrollPane(table);
        deleteButton = new DeleteButton(new DeleteListener(balance, table));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(deleteButton);

        this.add(tableScrollPane);
        this.add(buttonsPanel);
    }

    public BalanceTable getTable() {
        return table;
    }
}