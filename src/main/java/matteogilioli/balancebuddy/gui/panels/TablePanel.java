package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.BalanceTableModel;
import matteogilioli.balancebuddy.logic.BalanceEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public final class TablePanel extends JPanel {
    private final BalanceTableModel tableModel;
    private final JTable table;

    public TablePanel(ArrayList<BalanceEntry> entries) {
        super();

        tableModel = new BalanceTableModel(entries);
        table = new JTable(tableModel);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);

        JScrollPane tableScrollPane = new JScrollPane(table);

        this.add(tableScrollPane, BorderLayout.CENTER);
    }

    public int[] getSelectedIndexes() {
        return table.getSelectedRows();
    }

    public void updateTable() {
        tableModel.fireTableDataChanged();
    }
}
