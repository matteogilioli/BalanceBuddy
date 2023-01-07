package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.BalanceTable;
import matteogilioli.balancebuddy.gui.components.BalanceTableModel;
import matteogilioli.balancebuddy.logic.BalanceEntry;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public final class TablePanel extends JPanel {
    private final BalanceTableModel tableModel;
    private final JTable table;

    public TablePanel(ArrayList<BalanceEntry> entries) {
        super();

        tableModel = new BalanceTableModel(entries);
        table = new BalanceTable(tableModel);
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
