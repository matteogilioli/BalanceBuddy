package matteogilioli.balancebuddy.view.table;

import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.view.table.currency.CurrencyCellEditor;
import matteogilioli.balancebuddy.view.table.currency.CurrencyCellRenderer;
import matteogilioli.balancebuddy.view.table.date.DateCellEditor;
import matteogilioli.balancebuddy.view.table.date.DateCellRenderer;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class BalanceTable extends JTable {
    private final BalanceTableModel model;

    public BalanceTable(BalanceTableModel model) {
        super(model);
        this.model = model;

        this.setDefaultRenderer(Object.class, new BalanceTableCellRenderer());

        TableColumn dateColumn = this.getColumnModel().getColumn(0);
        TableColumn amountColumn = this.getColumnModel().getColumn(2);

        dateColumn.setCellEditor(new DateCellEditor());
        dateColumn.setCellRenderer(new DateCellRenderer());

        amountColumn.setCellEditor(new CurrencyCellEditor());
        amountColumn.setCellRenderer(new CurrencyCellRenderer());
    }

    public int[] getSelectedIndexes() {
        return this.getSelectedRows();
    }
}