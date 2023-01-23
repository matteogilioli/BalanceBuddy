package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.SpinnerDate;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.logic.Utility;
import matteogilioli.balancebuddy.logic.table.filter.DateRowFilter;
import matteogilioli.balancebuddy.logic.table.filter.FilterType;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

/**
 * Il {@link JPanel} che contiene i filtri per la tabella.
 */
public class FiltersPanel extends JPanel {

    /**
     * Testi mostrati difianco ai {@link #dateSpinner}.
     */
    private static final String[] labels = {"", "Anno", "Mese", "Settimana", "Giorno", "Dal", "al"};

    /**
     * {@link JLabel} mostrate difianco ai {@link #dateSpinner}.
     */
    private final JLabel[] jLabels = new JLabel[labels.length];

    /**
     * Selezione del tipo di filtro da applicare.
     */
    private final JRadioButton[] radioButtons = new JRadioButton[labels.length - 1];

    /**
     * Selezione della data da applicare al filtro.
     */
    private final JComponent[] dateSpinner = new JComponent[labels.length];

    /**
     * La {@link JTable} da filtrare.
     */
    private final BalanceTable table;

    /**
     * Costruttore che inizializza i {@link #dateSpinner filtri utilizzati},
     * i {@link #jLabels testi mostrati affianco} e i {@link #radioButtons radio buttons}.
     * @param table la {@link JTable} da filtrare
     */
    public FiltersPanel(BalanceTable table) {
        super();

        this.table = table;

        for (int i = 0; i < labels.length; i++)
            jLabels[i] = new JLabel(labels[i]);

        ButtonGroup radioGroup = new ButtonGroup();
        for(int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = new JRadioButton();
            radioButtons[i].addItemListener(new radioListener());
            radioGroup.add(radioButtons[i]);
        }

        dateSpinner[0] = new JTextField("Mostra tutto");
        dateSpinner[0].setFocusable(false);
        dateSpinner[1] = new SpinnerDate("yyyy");
        dateSpinner[2] = new SpinnerDate("MMMM yyyy");
        for (int i = 3; i < dateSpinner.length; i++)
            dateSpinner[i] = new SpinnerDate("dd/MM/yyyy");

        for (int i = 1; i < dateSpinner.length; i++)
            ((JSpinner) dateSpinner[i]).addChangeListener(new datetimeListener(i == 6 ? 5 : i));

        radioButtons[0].setSelected(true);

        createGUI();
    }

    /**
     * Crea l'interfaccia grafica, posizionando gli elementi nel {@link JPanel}.
     */
    private void createGUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < labels.length; i++) {
            c.gridx = 0; c.gridy = i;
            c.anchor = GridBagConstraints.LINE_END;
            c.insets = new Insets(5, 0, 0, 10);
            form.add(jLabels[i], c);
            c.insets = new Insets(5, 0, 0, 0);
            c.gridx++;
            dateSpinner[i].setPreferredSize(new Dimension(160, 30));
            form.add(dateSpinner[i], c);
            c.anchor = GridBagConstraints.LINE_START;
            c.gridx++;
            c.insets = new Insets(5, 10, 0, 0);
            if (i != labels.length - 1) form.add(radioButtons[i], c);
        }

        JLabel titleLabel = new JLabel("Filtri", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        this.add(titleLabel);
        this.add(Box.createVerticalStrut(5));
        this.add(form);
    }

    /**
     * Ottiene la data d'inizio e di fine selezionata dai {@link #dateSpinner}.
     * <ul>
     *     <li>Se il filtro non è "Mostra tutto", recupera la data d'inizio (altrimenti {@code null})</li>
     *     <li>Se il filtro è l'intervallo di date, recupera anche quella di fine (altrimenti {@code null})</li>
     * </ul>
     * Successivamente, chiama {@link DateRowFilter#setFilter(FilterType, LocalDate, LocalDate)} per impostare
     * i filtri e infine {@link BalanceTable#refreshSort()} per applicarli.
     * @param i l'indice corrispondente al {@link #dateSpinner} da cui ottenere la data
     */
    private void updateFilter(int i) {
        LocalDate startDate = (i == 0) ? null : Utility.getDate((JSpinner) dateSpinner[i]);
        LocalDate endDate = (i != radioButtons.length - 1) ? null : Utility.getDate((JSpinner) dateSpinner[i + 1]);
        table.getFilter().setFilter(FilterType.get(i), startDate, endDate);
        table.refreshSort();
    }

    /**
     * Classe annidata che utilizza un {@link ItemListener} per i {@link #radioButtons}.
     * Quando viene selezionato un radio button, disabilita graficamente gli altri {@link #dateSpinner} e {@link #jLabels}.
     */
    class radioListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                JRadioButton selectedButton = (JRadioButton) e.getSource();

                for (int i = 0; i < radioButtons.length; i++) {
                    boolean isSelected = radioButtons[i] == selectedButton;

                    dateSpinner[i].setEnabled(isSelected);
                    jLabels[i].setEnabled(isSelected);

                    if (i == radioButtons.length - 1) {
                        dateSpinner[i + 1].setEnabled(isSelected);
                        jLabels[i + 1].setEnabled(isSelected);
                    }

                    if (isSelected)
                        updateFilter(i);
                }
            }
        }
    }

    /**
     * Classe annidata che utilizza un {@link ChangeListener} per i {@link #dateSpinner}.
     * Quando viene modificata una data, aggiorna il filtro.
     */
    class datetimeListener implements ChangeListener {
        private final int i;

        public datetimeListener(int i) {
            this.i = i;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            updateFilter(i);
        }
    }
}