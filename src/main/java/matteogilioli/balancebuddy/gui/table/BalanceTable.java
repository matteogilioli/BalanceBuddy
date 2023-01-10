package matteogilioli.balancebuddy.gui.table;

import matteogilioli.balancebuddy.gui.table.logic.*;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class BalanceTable extends JTable {
    private final BalanceTableModel model;

    public BalanceTable(BalanceTableModel model) {
        super(model);
        this.model = model;

        TableColumn dateColumn = this.getColumnModel().getColumn(0);
        TableColumn amountColumn = this.getColumnModel().getColumn(2);

        dateColumn.setCellEditor(new DateCellEditor());
        dateColumn.setCellRenderer(new DateCellRenderer());

        amountColumn.setCellEditor(new DoubleCellEditor());
        amountColumn.setCellRenderer(new CurrencyCellRenderer());
    }

    public void updateTable() {
        model.fireTableDataChanged();
    }

    public int[] getSelectedIndexes() {
        return this.getSelectedRows();
    }
}
