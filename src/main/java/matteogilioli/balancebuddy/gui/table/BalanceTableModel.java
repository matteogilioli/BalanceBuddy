package matteogilioli.balancebuddy.gui.table;

import matteogilioli.balancebuddy.logic.Balance;
import matteogilioli.balancebuddy.logic.BalanceEntry;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public final class BalanceTableModel extends AbstractTableModel {
    private final Balance balance;
    private JLabel totalLabel;

    public BalanceTableModel(Balance balance, JLabel totalLabel) {
        this.balance = balance;
        this.totalLabel = totalLabel;
    }

    @Override
    public int getRowCount() {
        return balance.getEntries().size();
    }

    @Override
    public int getColumnCount() {
        return 3; // Data, descrizione, importo
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0:
                yield "Data";
            case 1:
                yield "Descrizione";
            case 2:
                yield "Importo";
            default:
                yield null;
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BalanceEntry voce = balance.getEntries().get(rowIndex);
        return switch (columnIndex) {
            case 0: // Data
                yield voce.getDatetime();
            case 1: // Descrizione
                yield voce.getDescription();
            case 2: // Importo
                yield voce.getAmount();
            default:
                yield null;
        };
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        BalanceEntry voce = balance.getEntries().get(rowIndex);
        switch (columnIndex) {
            case 0: // Data
                voce.setDatetime((Date) aValue);
                break;
            case 1: // Descrizione
                voce.setDescription((String) aValue);
                break;
            case 2: // Importo
                balance.editAmount(rowIndex, new BigDecimal(((Number) aValue).doubleValue()));
                fireTableDataChanged();
                break;
        }
    }

    public void fireTableDataChanged() {
        super.fireTableDataChanged();
        BigDecimal total = balance.getTotal();
        String totalText = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(total);
        totalLabel.setText("Bilancio Totale: " + totalText);
    }

    public ArrayList<BalanceEntry> getEntries() {
        return balance.getEntries();
    }
}
