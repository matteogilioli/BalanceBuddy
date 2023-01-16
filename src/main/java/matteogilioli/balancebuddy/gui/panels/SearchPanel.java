package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.controller.table.SearchAndSelect;
import matteogilioli.balancebuddy.gui.components.SearchButton;
import matteogilioli.balancebuddy.gui.table.BalanceTable;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    private final BalanceTable table;
    private final JTextField searchField;
    private final JButton searchButton;
    private String searchText;
    private SearchAndSelect s;

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

    private void search() {
        String text = searchField.getText().toLowerCase().trim();
        if (!text.equals(searchText)) {
            searchText = text;
            if (!text.isEmpty())
                newSearch();
        }

        if (text.isEmpty()) table.clearSelection();
        else s.searchAndSelect();
    }

    public void newSearch() {
        s = new SearchAndSelect(table, searchText, 1);
    }
}