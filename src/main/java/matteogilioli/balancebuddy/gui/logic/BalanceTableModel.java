package matteogilioli.balancebuddy.gui.logic;

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
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
                yield dtf.format(voce.getDatetime());
            case 1: // Descrizione
                yield voce.getDescription();
            case 2: // Importo
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                yield nf.format(voce.getAmount());
            default:
                yield null;
        };
    }
}
