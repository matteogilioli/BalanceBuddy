package matteogilioli.balancebuddy.view.table;

import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.view.table.currency.CurrencyCellEditor;
import matteogilioli.balancebuddy.view.table.currency.CurrencyCellColor;
import matteogilioli.balancebuddy.view.table.date.DateCellEditor;
import matteogilioli.balancebuddy.view.table.date.DateCellColor;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class BalanceTable extends JTable {
    public BalanceTable(BalanceTableModel model) {
        super(model);

        this.setDefaultRenderer(Object.class, new CellColor());

        TableColumn dateColumn = this.getColumnModel().getColumn(0);
        TableColumn amountColumn = this.getColumnModel().getColumn(2);

        dateColumn.setCellEditor(new DateCellEditor());
        dateColumn.setCellRenderer(new DateCellColor());

        amountColumn.setCellEditor(new CurrencyCellEditor());
        amountColumn.setCellRenderer(new CurrencyCellColor());
    }

    public int[] getSelectedIndexes() {
        return this.getSelectedRows();
    }
}
