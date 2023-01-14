package matteogilioli.balancebuddy.view.panels;

import matteogilioli.balancebuddy.controller.actions.DeleteListener;
import matteogilioli.balancebuddy.view.components.DeleteButton;
import matteogilioli.balancebuddy.view.table.BalanceTable;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private final BalanceTable table;
    private final JScrollPane tableScrollPane;
    private final JButton deleteButton;

    public TablePanel() {
        super();

        table = new BalanceTable();
        tableScrollPane = new JScrollPane(table);
        deleteButton = new DeleteButton(new DeleteListener(table));

        createGUI();
    }

    private void createGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        bottomPanel.add(deleteButton, BorderLayout.WEST);
        bottomPanel.add(new JLabel("Totale:"), BorderLayout.EAST);

        this.add(tableScrollPane);
        this.add(Box.createVerticalStrut(5));
        this.add(bottomPanel);
    }

    public BalanceTable getTable() {
        return table;
    }
}