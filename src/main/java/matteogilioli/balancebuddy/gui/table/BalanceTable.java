package matteogilioli.balancebuddy.gui.table;

import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.controller.table.DateRowFilter;
import matteogilioli.balancebuddy.gui.panels.SearchPanel;
import matteogilioli.balancebuddy.gui.table.currency.CurrencyCellColor;
import matteogilioli.balancebuddy.gui.table.currency.CurrencyCellEditor;
import matteogilioli.balancebuddy.gui.table.date.DateCellColor;
import matteogilioli.balancebuddy.gui.table.date.DateCellEditor;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class BalanceTable extends JTable {
    private final TableRowSorter<BalanceTableModel> sorter;
    private final DateRowFilter filter;
    private final JLabel totalLabel;
    private SearchPanel searchPanel;
    private static final Color expenseColor = new Color(194, 18, 18);
    private static final Color incomeColor = new Color(20, 140, 7);

    public BalanceTable(JLabel totalLabel) {
        super();

        this.totalLabel = totalLabel;

        BalanceTableModel model = new BalanceTableModel(this);
        this.setModel(model);
        this.setDefaultRenderer(Object.class, new CellColor());

        sorter = new TableRowSorter<>(model);
        sorter.toggleSortOrder(0);
        sorter.toggleSortOrder(0);
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
        int[] selectedRows = this.getSelectedRows();
        int[] selectedIndexes = new int[selectedRows.length];

        for (int i = 0; i < selectedRows.length; i++)
            selectedIndexes[i] = this.convertRowIndexToModel(selectedRows[i]);

        return selectedIndexes;
    }

    public DateRowFilter getFilter() {
        return filter;
    }

    public void setSearchPanel(SearchPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    public void refreshSort() {
        sorter.setRowFilter(filter);
        sorter.sort();

        BigDecimal totalAmount = BigDecimal.ZERO;
        for (int i = 0; i < this.getRowCount(); i++)
            totalAmount = totalAmount.add((BigDecimal) this.getValueAt(i, 2));

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String totalString = "Totale: " + currency.format(totalAmount);

        totalLabel.setText(totalString);
        if (totalAmount.compareTo(BigDecimal.ZERO) < 0)  totalLabel.setForeground(expenseColor);
        else if (totalAmount.compareTo(BigDecimal.ZERO) > 0) totalLabel.setForeground(incomeColor);
        else totalLabel.setForeground(Color.BLACK);
        searchPanel.newSearch();
    }
}