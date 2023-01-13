package matteogilioli.balancebuddy.controller.table;

import matteogilioli.balancebuddy.model.Balance;
import matteogilioli.balancebuddy.model.BalanceEntry;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public final class BalanceTableModel extends AbstractTableModel {
    private JLabel totalLabel;

    public BalanceTableModel(JLabel totalLabel) {
        this.totalLabel = totalLabel;
    }

    @Override
    public int getRowCount() {
        return Balance.getEntries().size();
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
        BalanceEntry voce = Balance.getEntries().get(rowIndex);
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
        BalanceEntry voce = Balance.getEntries().get(rowIndex);
        switch (columnIndex) {
            case 0: // Data
                Date date = (Date) aValue;
                Instant inst = date.toInstant();
                ZoneId zone = ZoneId.systemDefault();
                voce.setDatetime(LocalDateTime.ofInstant(inst, zone));
                break;
            case 1: // Descrizione
                voce.setDescription((String) aValue);
                break;
            case 2: // Importo
                Balance.editAmount(rowIndex, new BigDecimal(((Number) aValue).doubleValue()));
                refresh();
                break;
        }
    }

    public void refresh() {
        super.fireTableDataChanged();
        BigDecimal total = Balance.getTotal();
        String totalText = NumberFormat.getCurrencyInstance(Locale.getDefault()).format(total);
        totalLabel.setText("Bilancio Totale: " + totalText);
    }

    public ArrayList<BalanceEntry> getEntries() {
        return Balance.getEntries();
    }
}
