package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.gui.panels.FiltersPanel;
import matteogilioli.balancebuddy.gui.panels.SearchPanel;
import matteogilioli.balancebuddy.gui.panels.TablePanel;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.Utility;
import matteogilioli.balancebuddy.logic.file.backup.LoadBackup;
import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * La finestra principale dell'applicazione, fornisce un'interfaccia grafica
 * per l'utente tramite {@link javax.swing}.
 */
public class BudgetBuddyFrame extends JFrame {
    /**
     * Il panel contente la {@link BalanceTable tabella} di {@link BalanceEntry}.
     *
     * @see TablePanel
     */
    private final TablePanel tablePanel;

    /**
     * Il panel contente la barra di ricerca per la {@link BalanceTable tabella}.
     *
     * @see SearchPanel
     */
    private final SearchPanel searchPanel;

    /**
     * Il panel contente i filtri basati sulla data per la {@link BalanceTable tabella}.
     *
     * @see FiltersPanel
     */
    private final FiltersPanel filtersPanel;

    /**
     * Costruttore, inizializza i pannelli che compongono la finestra principale e il menu.
     * Informa la classe {@link Utility} che questa è la finestra principale.
     * Passa il riferimento della {@link BalanceTable tabella} creata in {@link TablePanel} ai pannelli
     * di {@link SearchPanel ricerca}, {@link FiltersPanel filtri} e al {@link MenuBar menu}.
     */
    public BudgetBuddyFrame() {
        super();

        Utility.setJFrame(this);
        tablePanel = new TablePanel();
        searchPanel = new SearchPanel(tablePanel.getTable());
        tablePanel.getTable().setSearchPanel(searchPanel);
        filtersPanel = new FiltersPanel(tablePanel.getTable());
        this.setJMenuBar(new MenuBar(tablePanel.getTable()));

        // Test data - DA CANCELLARE
        BalanceTableModel tableModel = tablePanel.getTable().getModel();
        try {
            Balance.setEntries(new LoadBackup(tableModel).loadFile(new File("examples/esempi.balancebuddy")));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        tableModel.refresh();
        // Test data - DA CANCELLARE

        createGUI();
    }

    /**
     * Inizializza l'interfaccia grafica della finestra principale,
     * impostando il titolo, la dimensione, la posizione e il layout della finestra.
     * Imposta anche che la finestra sia visibile e non ridimensionabile e
     * che si chiuda quando viene premuto il pulsante di chiusura.
     * Aggiunge i pannelli {@link SearchPanel ricerca}, {@link FiltersPanel filtri} e la {@link TablePanel tabella}.
     */
    private void createGUI() {
        this.setTitle("BalanceBuddy");

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(20));

        JPanel main = new JPanel(new GridBagLayout());
        main.add(Box.createHorizontalStrut(30));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(searchPanel);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(filtersPanel);

        main.add(leftPanel);
        main.add(Box.createHorizontalStrut(20));
        main.add(tablePanel);
        main.add(Box.createHorizontalStrut(20));
        this.add(main);

        this.add(Box.createVerticalStrut(20));
        this.pack();
        this.setMinimumSize(this.getSize());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
