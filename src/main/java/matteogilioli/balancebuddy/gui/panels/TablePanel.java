package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.buttons.DeleteButton;
import matteogilioli.balancebuddy.gui.buttons.listener.DeleteListener;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.gui.table.BalanceTableModel;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private final BalanceTableModel tableModel;
    private final BalanceTable table;
    private final JScrollPane tableScrollPane;
    private final JButton deleteButton;
    private final JLabel totalLabel;

    public TablePanel(Balance balance) {
        super();

        totalLabel = new JLabel();
        tableModel = new BalanceTableModel(balance, totalLabel);
        table = new BalanceTable(tableModel);
        tableScrollPane = new JScrollPane(table);
        deleteButton = new DeleteButton(new DeleteListener(balance, this));

        createGUI();
    }

    public void createGUI() {
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