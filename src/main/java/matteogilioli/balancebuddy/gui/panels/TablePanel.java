package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.buttons.DeleteButton;
import matteogilioli.balancebuddy.gui.components.buttons.listener.DeleteListener;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.gui.table.BalanceTableModel;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class TablePanel extends JPanel {
    private final BalanceTableModel tableModel;
    private final BalanceTable table;
    private final JScrollPane tableScrollPane;
    private final JButton deleteButton;
    private final JTextField totalField;
    private final Balance balance;

    public TablePanel(Balance balance) {
        super();

        tableModel = new BalanceTableModel(balance.getEntries());
        table = new BalanceTable(tableModel);
        tableScrollPane = new JScrollPane(table);
        deleteButton = new DeleteButton(new DeleteListener(balance, this));
        totalField = new JTextField();
        totalField.setEnabled(false);
        this.balance = balance;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        JPanel totalPanel = new JPanel();
        totalPanel.add(new JLabel("Totale:"));
        updateTotal();
        totalPanel.add(totalField);

        bottomPanel.add(deleteButton, BorderLayout.WEST);
        bottomPanel.add(totalPanel, BorderLayout.EAST);

        this.add(tableScrollPane);
        this.add(Box.createVerticalStrut(5));
        this.add(bottomPanel);
    }

    public BalanceTable getTable() {
        return table;
    }

    public void updateTable() {
        tableModel.fireTableDataChanged();
        updateTotal();
    }

    public void updateTotal() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        totalField.setText(currencyFormat.format(balance.getTotal()));
    }
}