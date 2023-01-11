package matteogilioli.balancebuddy.gui.components.panels;

import matteogilioli.balancebuddy.gui.components.buttons.DeleteButton;
import matteogilioli.balancebuddy.gui.components.buttons.listener.DeleteListener;
import matteogilioli.balancebuddy.gui.components.table.BalanceTable;
import matteogilioli.balancebuddy.gui.components.table.BalanceTableModel;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private final BalanceTableModel tableModel;
    private final BalanceTable table;
    private final JScrollPane tableScrollPane;
    private final JButton deleteButton;
    private final JLabel totalLabel;
    private final Balance balance;

    public TablePanel(Balance balance) {
        super();

        this.balance = balance;
        totalLabel = new JLabel();
        tableModel = new BalanceTableModel(balance, totalLabel);
        table = new BalanceTable(tableModel);
        tableScrollPane = new JScrollPane(table);
        deleteButton = new DeleteButton(new DeleteListener(balance, this));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        fireTableDataChanged();

        bottomPanel.add(deleteButton, BorderLayout.WEST);
        bottomPanel.add(totalLabel, BorderLayout.EAST);

        this.add(tableScrollPane);
        this.add(Box.createVerticalStrut(5));
        this.add(bottomPanel);
    }

    public BalanceTable getTable() {
        return table;
    }

    public void fireTableDataChanged() {
        tableModel.fireTableDataChanged();
    }
}