package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.controller.buttonsListener.DeleteListener;
import matteogilioli.balancebuddy.gui.components.DeleteButton;
import matteogilioli.balancebuddy.gui.table.BalanceTable;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private final BalanceTable table;
    private final JScrollPane tableScrollPane;
    private final JButton deleteButton;
    private final JLabel totalLabel;

    public TablePanel() {
        super();

        totalLabel = new JLabel("Totale: 0,00 €");
        table = new BalanceTable(totalLabel);
        tableScrollPane = new JScrollPane(table);
        deleteButton = new DeleteButton(new DeleteListener(table));

        createGUI();
    }

    private void createGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

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