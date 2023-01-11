package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.buttons.AddButton;
import matteogilioli.balancebuddy.gui.buttons.listener.AddListener;
import matteogilioli.balancebuddy.logic.Balance;
import matteogilioli.balancebuddy.logic.LocaleNumberFormatFactory;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class FormPanel extends JPanel {
    private static final String[] labels = {"Tipo", "Data", "Descrizione", "Importo"};
    private static final int rows = labels.length;
    private JLabel errorMessage = new JLabel(" ");
    private final AddButton addButton;
    private final JComboBox<String> type;
    private final JTextField description;
    private final JFormattedTextField amount;
    private final JSpinner datetime;

    public FormPanel(Balance balance, TablePanel tablePanel) {
        super();

        type = new JComboBox<>("Entrata, Uscita".split(", "));
        description = new JTextField();
        amount = new JFormattedTextField();
        amount.setFormatterFactory(new LocaleNumberFormatFactory());
        datetime = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datetime, "dd/MM/yyyy HH:mm");
        datetime.setEditor(dateEditor);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        errorMessage.setForeground(Color.RED);
        this.add(errorMessage, c);
        c.gridwidth = 1;

        JComponent[] components = {type, datetime, description, amount};

        for (int i = 0; i < rows; i++) {
            c.anchor = GridBagConstraints.LINE_END; c.gridx = 0; c.gridy = i + 1;
            c.insets = new Insets(5, 0, 0, 10);
            this.add(new JLabel(labels[i]), c);
            c.anchor = GridBagConstraints.LINE_START; c.gridx = 1;
            components[i].setPreferredSize(new Dimension(180, 30));
            this.add(components[i], c);
        }

        c.gridx = 1; c.gridy = rows + 1;
        addButton = new AddButton(new AddListener(this, tablePanel, balance));
        this.add(addButton, c);
    }

    public String getType() {
        return (String) type.getSelectedItem();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getAmount() {
        return amount.getText();
    }

    public Date getDatetime() {
        return (Date) datetime.getValue();
    }

    public void clear() {
        datetime.setValue(new Date());
        description.setText("");
        amount.setText("");
        errorMessage.setText(" ");
    }

    public void setError(String error) {
        errorMessage.setText(error);
    }
}