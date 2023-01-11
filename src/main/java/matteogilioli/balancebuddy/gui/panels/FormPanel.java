package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.buttons.AddButton;
import matteogilioli.balancebuddy.gui.buttons.listener.AddListener;
import matteogilioli.balancebuddy.gui.formatter.LocaleNumberFormatFactory;
import matteogilioli.balancebuddy.gui.spinner.SpinnerDateTime;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class FormPanel extends GenericFormPanel {
    private static final String[] labels = {"Tipo", "Data", "Descrizione", "Importo"};
    private JLabel errorMessage = new JLabel(" ");
    private final JComboBox<String> type;
    private final JTextField description;
    private final JFormattedTextField amount;
    private final JSpinner datetime;
    public final JButton addButton;

    public FormPanel(Balance balance, TablePanel tablePanel) {
        super();

        type = new JComboBox<>("Entrata, Uscita".split(", "));
        description = new JTextField();
        amount = new JFormattedTextField();
        amount.setFormatterFactory(new LocaleNumberFormatFactory());
        datetime = new SpinnerDateTime();
        addButton = new AddButton(new AddListener(this, tablePanel, balance));

        createGUI();
    }

    public void createGUI() {
        JComponent[] components = {type, datetime, description, amount};
        super.populate(labels, components, errorMessage, addButton);
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

    public LocalDateTime getDatetime() {
        Object obj = datetime.getValue();
        Date date = (Date) obj;
        Instant inst = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(inst, zone);
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