package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.logic.BalanceTableModel;
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

        DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
        rightRender.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(2).setCellRenderer(rightRender);

        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRender);

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
