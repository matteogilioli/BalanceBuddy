package matteogilioli.balancebuddy.view.panels;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.model.FilterType;
import matteogilioli.balancebuddy.view.components.SpinnerDate;
import matteogilioli.balancebuddy.view.table.BalanceTable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

public class FiltersPanel extends JPanel {
    private static final String title = "Filtri";
    private static final String[] labels = {"", "Anno", "Mese", "Settimana", "Giorno", "Dal", "al"};
    private final JLabel[] jLabels = new JLabel[labels.length];
    private final JRadioButton[] radioButtons = new JRadioButton[labels.length - 1];
    private final JComponent[] dateSpinner = new JComponent[labels.length];
    private final BalanceTable table;

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
        for (int i = 3; i < dateSpinner.length; i++) {
            dateSpinner[i] = new SpinnerDate("dd/MM/yyyy");
        }

        for (int i = 1; i < dateSpinner.length; i++)
            ((JSpinner) dateSpinner[i]).addChangeListener(new datetimeListener(i));

        radioButtons[0].setSelected(true);

        createGUI();
    }

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

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        this.add(titleLabel);
        this.add(Box.createVerticalStrut(5));
        this.add(form);
    }

    private void updateFilter(int i) {
        LocalDate startDate = (i == 0) ? null : Utility.getDate((JSpinner) dateSpinner[i]);
        LocalDate endDate = (i != radioButtons.length - 1) ? null : Utility.getDate((JSpinner) dateSpinner[i + 1]);
        table.getFilter().setFilter(FilterType.get(i), startDate, endDate);
        table.refreshSort();
    }

    class radioListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
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