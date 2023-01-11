package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.SpinnerDate;

import javax.swing.*;
import java.awt.*;

public class FiltersPanel extends JPanel {
    private static final String[] labels = {"Filtro date", "Dal giorno", "Al giorno"};
    private final JCheckBox filterCheckBox;
    private final JSpinner datetimeStart;
    private final JSpinner datetimeEnd;

    public FiltersPanel() {
        super();

        filterCheckBox = new JCheckBox("Attiva");

        datetimeStart = new SpinnerDate();
        datetimeEnd = new SpinnerDate();

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