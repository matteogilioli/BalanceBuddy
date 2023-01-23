package matteogilioli.balancebuddy.gui.table;

import matteogilioli.balancebuddy.gui.panels.FiltersPanel;
import matteogilioli.balancebuddy.gui.panels.SearchPanel;
import matteogilioli.balancebuddy.gui.table.renderer.CellColor;
import matteogilioli.balancebuddy.gui.table.renderer.CurrencyCellColor;
import matteogilioli.balancebuddy.gui.table.renderer.DateCellColor;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;
import matteogilioli.balancebuddy.logic.table.editor.CurrencyCellEditor;
import matteogilioli.balancebuddy.logic.table.editor.DateCellEditor;
import matteogilioli.balancebuddy.logic.table.filter.DateRowFilter;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * La tabella che mostra le {@link BalanceEntry voci di bilancio}.
 */
public class BalanceTable extends JTable {
    /**
     * Colore utilizzato da {@link #totalLabel} per indicare che il bilancio è negativo.
     */
    private static final Color expenseColor = new Color(194, 18, 18);

    /**
     * Colore utilizzato da {@link #totalLabel} per indicare che il bilancio è positivo.
     */
    private static final Color incomeColor = new Color(20, 140, 7);

    /**
     * Il {@link TableModel} personalizzato di {@link BalanceTable}.
     */
    private final BalanceTableModel model;

    /**
     * Permette di filtrare le righe della tabella.
     */
    private final TableRowSorter<BalanceTableModel> sorter;

    /**
     * Il {@link RowFilter} personalizzato per filtrare la tabella basandosi sulle date
     * in input fornite da {@link FiltersPanel}.
     */
    private final DateRowFilter filter;

    /**
     * Il testo mostrato in fondo alla tabella, rappresenta il totale delle voci di bilancio.
     */
    private final JLabel totalLabel;

    /**
     * Il panel contenente la barra di ricerca e il pulsante relativo.
     */
    private SearchPanel searchPanel;

    /**
     * Costruttore, inizializza la tabella, il {@link TableRowSorter} e il {@link RowFilter}.
     * Imposta gli editor e i renderer delle colonne.
     *
     * @param totalLabel il testo mostrato in fondo alla tabella, rappresenta il totale delle voci di bilancio
     */
    public BalanceTable(JLabel totalLabel) {
        super();

        this.totalLabel = totalLabel;

        model = new BalanceTableModel(this);
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

    /**
     * Converte gli indici delle righe selezionate in modo da poter accedere alle voci di bilancio corrette.
     * @return un array di indici delle righe selezionate, convertiti in base al {@link TableRowSorter}
     */
    public int[] getSelectedIndexes() {
        int[] selectedRows = this.getSelectedRows();
        int[] selectedIndexes = new int[selectedRows.length];

        for (int i = 0; i < selectedRows.length; i++)
            selectedIndexes[i] = this.convertRowIndexToModel(selectedRows[i]);

        return selectedIndexes;
    }

    /**
     * @return il {@link RowFilter} utilizzato per filtrare la tabella
     */
    public DateRowFilter getFilter() {
        return filter;
    }

    /**
     * @return il testo mostrato in fondo alla tabella, rappresenta il totale delle voci di bilancio
     */
    public JLabel getTotalLabel() {
        return totalLabel;
    }

    /**
     * Imposta il {@link #searchPanel} per poterlo utilizzare per resettare la ricerca.
     * @param searchPanel il pannello di ricerca
     */
    public void setSearchPanel(SearchPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    /**
     * Imposta il nuovo {@link #filter}, aggiorna il {@link #sorter} e resetta la ricerca.
     * Calcola anche {@link #totalLabel} in base al nuovo filtro.
     */
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

    /**
     * @return il {@link #model} della tabella ({@link BalanceTableModel})
     */
    @Override
    public BalanceTableModel getModel() {
        return model;
    }
}
