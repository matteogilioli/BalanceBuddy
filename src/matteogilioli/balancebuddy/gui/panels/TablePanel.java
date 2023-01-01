package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.logic.BalanceEntry;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public final class TablePanel extends JPanel {
    private final BalanceTableModel tableModel;
    private final JTable table;
    private final ArrayList<BalanceEntry> entries;

    public TablePanel(ArrayList<BalanceEntry> entries) {
        super();

        this.entries = entries;

        tableModel = new BalanceTableModel();
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        this.add(tableScrollPane, BorderLayout.CENTER);
    }

    public int[] getSelectedIndexes() {
        return table.getSelectedRows();
    }

    public void updateTable() {
        tableModel.fireTableDataChanged();
    }

    public final class BalanceTableModel extends AbstractTableModel {
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
                    yield voce.getAmount();
                case 2: // Data
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
                    yield dtf.format(voce.getDatetime());
                default:
                    yield null;
            };
        }
    }
}
