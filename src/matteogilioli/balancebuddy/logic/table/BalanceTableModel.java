package matteogilioli.balancebuddy.logic.table;

import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Il {@link TableModel} personalizzato di {@link BalanceTable}.
 */
public final class BalanceTableModel extends AbstractTableModel {
    /**
     * La tabella su cui è applicato il {@link TableModel}.
     */
    private final BalanceTable table;

    /**
     * @param table la tabella su cui è applicato il {@link TableModel}
     */
    public BalanceTableModel(BalanceTable table) {
        super();
        this.table = table;
    }

    /**
     * @return il numero di righe della tabella
     */
    @Override
    public int getRowCount() {
        return Balance.getEntries().size();
    }

    /**
     * @return il numero di colonne della tabella
     */
    @Override
    public int getColumnCount() {
        return 3; // Data, descrizione, importo
    }

    /**
     * @param columnIndex l'indice della colonna
     * @return il nome della colonna
     */
    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Data";
            case 1 -> "Descrizione";
            case 2 -> "Importo";
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    /**
     * @param rowIndex    l'indice della riga
     * @param columnIndex l'indice della colonna
     * @return il valore della cella corrispondente
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BalanceEntry voce = Balance.getEntries().get(rowIndex);
        return switch (columnIndex) {
            case 0 -> voce.getDatetime();
            case 1 -> voce.getDescription();
            case 2 -> voce.getAmount();
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    /**
     * Indica se la cella è modificabile.
     *
     * @param rowIndex    l'indice della riga
     * @param columnIndex l'indice della colonna
     * @return true, per permettere la modifica di tutte le celle
     */
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    /**
     * Imposta il valore della cella e chiama {@link BalanceTableModel#refresh()}.
     *
     * @param aValue      il valore da assegnare alla cella
     * @param rowIndex    l'indice della riga
     * @param columnIndex l'indice della colonna
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        BalanceEntry voce = Balance.getEntries().get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                Date date = (Date) aValue;
                Instant inst = date.toInstant();
                ZoneId zone = ZoneId.systemDefault();
                voce.setDatetime(LocalDateTime.ofInstant(inst, zone));
            }
            case 1 -> voce.setDescription((String) aValue);
            case 2 -> Balance.editAmount(rowIndex, new BigDecimal(aValue.toString()));
        }

        refresh();
    }

    /**
     * Aggiorna il {@link TableModel} con {@link BalanceTableModel#fireTableDataChanged()}.
     * Chiama {@link BalanceTable#refreshSort()} per indicare che è necessario riordinare la tabella e aggiornare il totale.
     */
    public void refresh() {
        super.fireTableDataChanged();
        table.refreshSort();
    }

    /**
     * Restisce la classe della colonna con l'indice specificato.
     *
     * @param columnIndex l'indice della colonna
     * @return la classe della colonna
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> LocalDateTime.class;
            case 1 -> String.class;
            case 2 -> BigDecimal.class;
            default -> Object.class;
        };
    }
}
