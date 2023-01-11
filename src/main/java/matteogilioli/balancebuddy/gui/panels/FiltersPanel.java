package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.spinner.SpinnerDate;

import javax.swing.*;

public class FiltersPanel extends GenericFormPanel {
    private static final String[] labels = {"Filtro date", "Dal giorno", "Al giorno"};
    private final JCheckBox filterCheckBox;
    private final JSpinner datetimeStart;
    private final JSpinner datetimeEnd;

    public FiltersPanel() {
        super();

        filterCheckBox = new JCheckBox("Attiva");
        datetimeStart = new SpinnerDate();
        datetimeEnd = new SpinnerDate();

        createGUI();
    }

    public void createGUI() {
        JComponent[] components = {filterCheckBox, datetimeStart, datetimeEnd};
        this.populate(labels, components);
    }
}