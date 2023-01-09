package matteogilioli.balancebuddy.gui.table;

import matteogilioli.balancebuddy.logic.BalanceEntry;

import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

public final class BalanceTableModel extends AbstractTableModel {
    private final ArrayList<BalanceEntry> entries;

    public BalanceTableModel(ArrayList<BalanceEntry> entries) {
        this.entries = entries;
    }

    @Override
    public int getRowCount() {
        return entries.size();
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
        BalanceEntry voce = entries.get(rowIndex);
        return switch (columnIndex) {
            case 0: // Data
                yield voce.getDatetime();
            case 1: // Descrizione
                yield voce.getDescription();
            case 2: // Importo
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                yield nf.format(voce.getAmount());
            default:
                yield null;
        };
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        BalanceEntry voce = entries.get(rowIndex);
        switch (columnIndex) {
            case 0: // Data
                voce.setDatetime((Date) aValue);
                break;
            case 1: // Descrizione
                voce.setDescription((String) aValue);
                break;
        }
    }
}
