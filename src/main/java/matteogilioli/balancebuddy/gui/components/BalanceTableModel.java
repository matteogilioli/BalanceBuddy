package matteogilioli.balancebuddy.gui.components;

import matteogilioli.balancebuddy.logic.BalanceEntry;

import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
        return 3; // Descrizione, Importo, Data
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0:
                yield "Descrizione";
            case 1:
                yield "Importo";
            case 2:
                yield "Data";
            default:
                yield null;
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BalanceEntry voce = entries.get(rowIndex);
        return switch (columnIndex) {
            case 0: // Descrizione
                yield voce.getDescription();
            case 1: // Importo
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                yield nf.format(voce.getAmount());
            case 2: // Data
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
                yield dtf.format(voce.getDatetime());
            default:
                yield null;
        };
    }
}
