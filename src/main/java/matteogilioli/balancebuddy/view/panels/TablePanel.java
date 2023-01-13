package matteogilioli.balancebuddy.view.panels;

import matteogilioli.balancebuddy.controller.Application;
import matteogilioli.balancebuddy.view.components.DeleteButton;
import matteogilioli.balancebuddy.controller.actions.DeleteListener;
import matteogilioli.balancebuddy.view.table.BalanceTable;
import matteogilioli.balancebuddy.controller.table.BalanceTableModel;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private final BalanceTableModel tableModel;
    private final BalanceTable table;
    private final JScrollPane tableScrollPane;
    private final JButton deleteButton;
    private final JLabel totalLabel;

    public TablePanel() {
        super();

        totalLabel = new JLabel();
        tableModel = new BalanceTableModel(totalLabel);
        Application.setTableModel(tableModel);
        table = new BalanceTable(tableModel);
        tableScrollPane = new JScrollPane(table);
        deleteButton = new DeleteButton(new DeleteListener(this));

        createGUI();
    }

    private void createGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        Application.refreshData();

        bottomPanel.add(deleteButton, BorderLayout.WEST);
        bottomPanel.add(totalLabel, BorderLayout.EAST);

        this.add(tableScrollPane);
        this.add(Box.createVerticalStrut(5));
        this.add(bottomPanel);
    }

    public BalanceTable getTable() {
        return table;
    }
}