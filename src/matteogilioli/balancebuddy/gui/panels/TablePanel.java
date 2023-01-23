package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.DeleteButton;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.actions.buttonsListener.DeleteListener;

import javax.swing.*;
import java.awt.*;

/**
 * Il {@link JPanel} utilizzato per la mostrare i movimenti in una {@link JTable}.
 */
public class TablePanel extends JPanel {

    /**
     * La {@link JTable} che mostra i movimenti.
     */
    private final BalanceTable table;

    /**
     * Rende la {@link JTable} scrollabile, in modo da poter vedere tutti i movimenti.
     */
    private final JScrollPane tableScrollPane;

    /**
     * Il {@link DeleteButton} utilizzato per eliminare i movimenti selezionati.
     */
    private final JButton deleteButton;

    /**
     * Il testo mostrato in fondo alla {@link #table tabella}, rappresenta il totale delle voci di bilancio.
     */
    private final JLabel totalLabel;

    /**
     * Costruttore che inizializza il {@link JPanel} con la {@link JTable} e il {@link DeleteButton},
     * creando anche il {@link JScrollPane} per rendere la tabella scrollabile.
     */
    public TablePanel() {
        super();

        totalLabel = new JLabel("Totale: 0,00 €");
        table = new BalanceTable(totalLabel);
        tableScrollPane = new JScrollPane(table);
        deleteButton = new DeleteButton(new DeleteListener(table));

        createGUI();
    }

    /**
     * Crea l'interfaccia grafica, posizionando gli elementi nel {@link JPanel}.
     */
    private void createGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        bottomPanel.add(deleteButton, BorderLayout.WEST);
        bottomPanel.add(totalLabel, BorderLayout.EAST);

        this.add(tableScrollPane);
        this.add(Box.createVerticalStrut(5));
        this.add(bottomPanel);
    }

    /**
     * @return la {@link JTable} contenuta nel {@link JPanel}, come oggetto di tipo {@link BalanceTable}
     */
    public BalanceTable getTable() {
        return table;
    }
}