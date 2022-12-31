package gui.panels;

import logic.VoceBilancio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BudgetTablePanel extends JPanel {
    private final BudgetTableModel tableModel;
    private final JTable table;
    private final JScrollPane tableScrollPane;
    private final ArrayList<VoceBilancio> voci;

    public BudgetTablePanel(ArrayList<VoceBilancio> voci) {
        super();

        this.voci = voci;

        tableModel = new BudgetTableModel();
        table = new JTable(tableModel);
        tableScrollPane = new JScrollPane(table);

        this.add(tableScrollPane, BorderLayout.CENTER);
    }

    public class BudgetTableModel extends AbstractTableModel {
        @Override
        public int getRowCount() {
            return voci.size();
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
            VoceBilancio voce = voci.get(rowIndex);
            switch (columnIndex) {
                case 0: // Descrizione
                    return voce.getDescrizione();
                case 1: // Importo
                    return voce.getImporto();
                case 2: // Data
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
                    return dtf.format(voce.getData());
                default:
                    return null;
            }
        }
    }
}
