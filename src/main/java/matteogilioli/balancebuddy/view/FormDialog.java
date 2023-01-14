package matteogilioli.balancebuddy.view;

import matteogilioli.balancebuddy.controller.Utility;
import matteogilioli.balancebuddy.controller.actions.AddListener;
import matteogilioli.balancebuddy.view.components.AddButton;
import matteogilioli.balancebuddy.view.components.SpinnerDate;
import matteogilioli.balancebuddy.view.formatter.LocaleNumberFormatFactory;
import matteogilioli.balancebuddy.view.table.BalanceTable;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class FormDialog extends JDialog {
    private static final String[] labels = {"Tipo", "Data", "Descrizione", "Importo"};
    private final JComboBox<String> type;
    private final JTextField description;
    private final JFormattedTextField amount;
    private final JSpinner datetime;
    public final JButton addButton;

    public FormDialog(String entryType, BalanceTable table) {
        super();

        type = new JComboBox<>("Entrata, Uscita".split(", "));
        type.addItemListener(e -> changeType((String) e.getItem()));
        description = new JTextField();
        amount = new JFormattedTextField();
        amount.setFormatterFactory(new LocaleNumberFormatFactory());
        datetime = new SpinnerDate("dd/MM/yyyy HH:mm");
        addButton = new AddButton(new AddListener(this, table));

        changeType(entryType);

        createGUI();
    }

    private void createGUI() {
        JComponent[] components = {type, datetime, description, amount};
        this.setLayout(new GridBagLayout());
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < components.length; i++) {
            c.anchor = GridBagConstraints.LINE_END; c.gridx = 0; c.gridy = i;
            c.insets = new Insets(5, 0, 0, 10);
            form.add(new JLabel(labels[i]), c);
            c.insets = new Insets(5, 0, 0, 0);
            c.anchor = GridBagConstraints.LINE_START; c.gridx = 1;
            components[i].setPreferredSize(new Dimension(180, 30));
            form.add(components[i], c);
        }

        if (addButton != null) {
            c.gridx = 1; c.gridy = components.length + 1;
            form.add(addButton, c);
        }

        c.insets = new Insets(30, 30, 30, 30);
        this.add(form, c);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(Utility.getJFrame());
        this.setVisible(true);
    }

    public String getSelectedType() {
        return (String) type.getSelectedItem();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getAmount() {
        return amount.getText();
    }

    public LocalDateTime getDatetime() {
        return Utility.getDateTime(datetime);
    }

    private void changeType(String entryType) {
        switch (entryType) {
            case "Entrata" -> {
                type.setSelectedItem("Entrata");
                this.setTitle("Aggiungi Entrata");
            }
            case "Uscita" -> {
                type.setSelectedItem("Uscita");
                this.setTitle("Aggiungi Uscita");
            }
            default -> throw new IllegalStateException("Unexpected value: " + entryType);
        }
    }

    public void setError(String error) {
        JOptionPane.showMessageDialog(this, error, "Creazione fallita", JOptionPane.ERROR_MESSAGE);
    }
}