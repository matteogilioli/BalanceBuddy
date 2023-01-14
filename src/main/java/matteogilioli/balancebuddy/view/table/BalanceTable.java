package matteogilioli.balancebuddy.view.table;

import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.controller.table.DateRowFilter;
import matteogilioli.balancebuddy.view.table.currency.CurrencyCellColor;
import matteogilioli.balancebuddy.view.table.currency.CurrencyCellEditor;
import matteogilioli.balancebuddy.view.table.date.DateCellColor;
import matteogilioli.balancebuddy.view.table.date.DateCellEditor;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class BalanceTable extends JTable {
    private final TableRowSorter<BalanceTableModel> sorter;
    private final DateRowFilter filter;

    public BalanceTable() {
        super();

        BalanceTableModel model = new BalanceTableModel(this);
        this.setModel(model);
        this.setDefaultRenderer(Object.class, new CellColor());

        sorter = new TableRowSorter<>(model);
        filter = new DateRowFilter();
        sorter.setRowFilter(filter);
        this.setRowSorter(sorter);

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

    public DateRowFilter getFilter() {
        return filter;
    }

    public void refreshSort() {
        sorter.setRowFilter(filter);
        sorter.sort();
    }
}
