package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.buttons.AddButton;
import matteogilioli.balancebuddy.gui.buttons.listener.AddListener;
import matteogilioli.balancebuddy.gui.logic.LocaleNumberFormatFactory;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class FiltersPanel extends JPanel {
    private static final String[] labels = {"Filtro date", "Da", "A"};
    private final JCheckBox filterCheckBox;
    private final JSpinner datetimeStart;
    private final JSpinner datetimeEnd;
    private JLabel errorMessage = new JLabel(" ");

    public FiltersPanel() {
        super();

        filterCheckBox = new JCheckBox("Attiva");

        datetimeStart = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditorStart = new JSpinner.DateEditor(datetimeStart, "dd/MM/yyyy");
        datetimeStart.setEditor(dateEditorStart);

        datetimeEnd = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditorEnd = new JSpinner.DateEditor(datetimeEnd, "dd/MM/yyyy");
        datetimeEnd.setEditor(dateEditorEnd);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JComponent[] components = {filterCheckBox, datetimeStart, datetimeEnd};

        for (int i = 0; i < components.length; i++) {
            c.anchor = GridBagConstraints.LINE_END; c.gridx = 0; c.gridy = i;
            c.insets = new Insets(5, 0, 0, 10);
            this.add(new JLabel(labels[i]), c);
            c.insets = new Insets(5, 0, 0, 0);
            c.anchor = GridBagConstraints.LINE_START; c.gridx = 1;
            components[i].setPreferredSize(new Dimension(180, 30));
            this.add(components[i], c);
        }
    }
}