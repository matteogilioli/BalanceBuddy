package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.SearchButton;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.table.filter.SearchAndSelect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Il {@link JPanel} utilizzato per la ricerca.
 */
public class SearchPanel extends JPanel {
    /**
     * La {@link JTable} da filtrare.
     */
    private final BalanceTable table;

    /**
     * Il {@link JTextField} utilizzato per la ricerca.
     */
    private final JTextField searchField;

    /**
     * Il {@link SearchButton} utilizzato per avviare la ricerca.
     */
    private final JButton searchButton;

    /**
     * Campo testuale per ricordare l'ultima ricerca effettuata.
     */
    private String searchText;

    /**
     * Riferimmento al {@link SearchAndSelect} utilizzato per la ricerca e la selezione.
     */
    private SearchAndSelect s;

    /**
     * Costruttore che inizializza il {@link #searchField campo testuale} e il {@link #searchButton bottone}.
     * Aggiunge un {@link ActionListener} al {@link #searchButton bottone} e al {@link #searchField campo testuale},
     * in modo che la ricerca venga avviata quando viene premuto il tasto invio o il bottone.
     * @param table la {@link JTable} da filtrare
     */
    public SearchPanel(BalanceTable table) {
        super();

        this.table = table;
        searchField = new JTextField(20);
        searchButton = new SearchButton();
        searchField.addActionListener(e -> search());
        searchButton.addActionListener(e -> search());
        searchText = "";

        createGUI();
    }

    /**
     * Crea l'interfaccia grafica, posizionando gli elementi nel {@link JPanel}.
     */
    private void createGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel searchBar = new JPanel();
        searchBar.add(searchField);
        searchBar.add(searchButton);

        JLabel titleLabel = new JLabel("Ricerca", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        this.add(titleLabel);
        this.add(Box.createVerticalStrut(5));
        this.add(searchBar);
    }

    /**
     * Controlla se il testo inserito nel {@link #searchField campo testuale} è diverso dall'ultima ricerca effettuata.
     * <ul>
     *     <li>Se è diverso, crea una nuova ricerca con {@link #newSearch()} e la avvia con {@link SearchAndSelect#searchNext()}</li>
     *     <li>Se è uguale, seleziona la prossima occorrenza con {@link SearchAndSelect#searchNext()}</li>
     *     <li>Se è vuoto, cancella la selezione con {@link JTable#clearSelection()}</li>
     * </ul>
     */
    private void search() {
        String text = searchField.getText().toLowerCase().trim();
        if (!text.equals(searchText)) {
            searchText = text;
            if (!text.isEmpty())
                newSearch();
        }

        if (text.isEmpty()) table.clearSelection();
        else s.searchNext();
    }

    /**
     * Avvia una nuova ricerca, creando un nuovo {@link SearchAndSelect}.
     */
    public void newSearch() {
        s = new SearchAndSelect(table, searchText, 1);
    }
}