package matteogilioli.balancebuddy.gui.components.panels;

import matteogilioli.balancebuddy.gui.components.buttons.AddButton;
import matteogilioli.balancebuddy.gui.components.buttons.listener.AddListener;
import matteogilioli.balancebuddy.gui.components.spinner.SpinnerDateTime;
import matteogilioli.balancebuddy.gui.logic.LocaleNumberFormatFactory;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class FormPanel extends GenericFormPanel {
    private static final String[] labels = {"Tipo", "Data", "Descrizione", "Importo"};
    private static final int rows = labels.length;
    private JLabel errorMessage = new JLabel(" ");
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
        datetime = new SpinnerDateTime();

        ActionListener addListener = new AddListener(this, tablePanel, balance);
        createGUI(addListener);
    }

    public void createGUI(ActionListener addListener) {
        JComponent[] components = {type, datetime, description, amount};
        super.populate(labels, components, errorMessage, new AddButton(addListener));
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