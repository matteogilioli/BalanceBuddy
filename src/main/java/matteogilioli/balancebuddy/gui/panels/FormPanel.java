package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.buttons.AddButton;
import matteogilioli.balancebuddy.gui.components.buttons.listener.AddListener;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.gui.table.logic.CurrencyFilter;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.util.Date;

public class FormPanel extends JPanel {
    private static final String[] labels = {"Tipo", "Data", "Descrizione", "Importo"};
    private static final int rows = labels.length;
    private JLabel errorMessage = new JLabel(" ");
    private final AddButton addButton;
    private final JComboBox<String> type = new JComboBox<>("Entrata, Uscita".split(", "));
    private final JTextField description = new JTextField();
    private final JTextField amount = new JTextField();
    private final JSpinner datetime = new JSpinner(new SpinnerDateModel());

    public FormPanel(Balance balance, TablePanel tablePanel) {
        super();

        AbstractDocument doc = (AbstractDocument) amount.getDocument();
        doc.setDocumentFilter(new CurrencyFilter());

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datetime, "dd/MM/yyyy HH:mm");
        datetime.setEditor(dateEditor);

        type.setPreferredSize(new Dimension(180, 30));
        datetime.setPreferredSize(new Dimension(180, 30));
        description.setPreferredSize(new Dimension(180, 30));
        amount.setPreferredSize(new Dimension(180, 30));

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
        return amount.getText().replace(",", ".");
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