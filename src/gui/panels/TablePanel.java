package gui.panels;

import logic.BalanceEntry;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TablePanel extends JPanel {
    private final BudgetTableModel tableModel;
    private final JTable table;
    private final JScrollPane tableScrollPane;
    private final ArrayList<BalanceEntry> entries;

    public TablePanel(ArrayList<BalanceEntry> entries) {
        super();

        this.entries = entries;

        tableModel = new BudgetTableModel();
        table = new JTable(tableModel);
        tableScrollPane = new JScrollPane(table);

        this.add(tableScrollPane, BorderLayout.CENTER);
    }

    public class BudgetTableModel extends AbstractTableModel {
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
            switch(columnIndex) {
                case 0: return "Descrizione";
                case 1: return "Importo";
                case 2: return "Data";
                default: return null;
            }
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            BalanceEntry voce = entries.get(rowIndex);
            switch (columnIndex) {
                case 0: // Descrizione
                    return voce.getDescription();
                case 1: // Importo
                    return voce.getAmount();
                case 2: // Data
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
                    return dtf.format(voce.getDatetime());
                default:
                    return null;
            }
        }
    }
}
