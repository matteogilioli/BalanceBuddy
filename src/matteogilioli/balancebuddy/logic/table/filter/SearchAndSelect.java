package matteogilioli.balancebuddy.logic.table.filter;

import matteogilioli.balancebuddy.gui.panels.SearchPanel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.ArrayList;

/**
 * Si occupa la selezione delle righe di una tabella, in base a una stringa di ricerca.
 */
public class SearchAndSelect {
    /**
     * {@link ArrayList} di {@link Integer} che contiene gli indici delle righe che soddisfano la ricerca.
     */
    private final ArrayList<Integer> matches = new ArrayList<>();

    /**
     * {@link JTable} su cui effettuare la ricerca.
     */
    private final JTable table;

    /**
     * Contiene l'indice della prossima riga della tabella da selezionare
     */
    private int nextMatch = 0;

    /**
     * Costruttore della classe.
     * Inizializza un {@link ArrayList} per memorizzare gli indici delle righe che soddisfano la ricerca.
     * Per ogni ricerca, viene inizializzato un nuovo oggetto.
     *
     * @param table        tabella su cui effettuare la ricerca e la selezione
     * @param searchText   testo da cercare
     * @param searchColumn colonna in cui cercare
     * @see SearchPanel
     */
    public SearchAndSelect(JTable table, String searchText, int searchColumn) {
        this.table = table;
        TableModel model = table.getModel();
        for (int row = 0; row < table.getRowCount(); row++) {
            int modelRow = table.convertRowIndexToModel(row);
            Object value = model.getValueAt(modelRow, searchColumn);
            if (value.toString().toLowerCase().contains(searchText.toLowerCase()))
                matches.add(row);
        }
    }

    /**
     * Seleziona la prossima riga che soddisfa la ricerca, in base al contenuto di {@link #nextMatch}, e lo aggiorna alla
     * prossima riga da selezionare, se esiste. Se non esiste, lo reimposta a 0 per poter ricominciare da capo.
     * Se non ci sono righe che soddisfano la ricerca, deseleziona tutte le righe attualmente selezionate.
     */
    public void searchNext() {
        if (matches.size() > 0) {
            int row = matches.get(nextMatch);
            table.setRowSelectionInterval(row, row);
            table.scrollRectToVisible(table.getCellRect(row, 0, true));
            nextMatch = (nextMatch + 1) % matches.size();
        } else {
            table.clearSelection();
        }
    }
}
