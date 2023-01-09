package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.buttons.AddButton;
import matteogilioli.balancebuddy.gui.buttons.listener.AddListener;
import matteogilioli.balancebuddy.gui.table.BalanceTable;
import matteogilioli.balancebuddy.gui.table.logic.CurrencyFilter;
import matteogilioli.balancebuddy.logic.Balance;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class FormPanel extends JPanel {
    private static final String[] labels = {"Tipo", "Data", "Descrizione", "Importo"};
    private static final int rows = labels.length;
    private final AddButton addButton;
    private final JComboBox<String> type = new JComboBox<>("Entrata, Uscita".split(", "));
    private final JTextField description = new JTextField();
    private final JTextField amount = new JTextField();
    private final JSpinner datetime = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.MONTH));

    public FormPanel(Balance balance, BalanceTable table) {
        super();

        type.setPreferredSize(new Dimension(180, 30));
        datetime.setPreferredSize(new Dimension(180, 30));
        description.setPreferredSize(new Dimension(180, 30));
        amount.setPreferredSize(new Dimension(180, 30));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        AbstractDocument doc = (AbstractDocument) amount.getDocument();
        doc.setDocumentFilter(new CurrencyFilter());

        JComponent[] components = {type, datetime, description, amount};

        for (int i = 0; i < rows; i++) {
            c.anchor = GridBagConstraints.LINE_END; c.gridx = 0; c.gridy = i;
            c.insets = new Insets(5, 0, 0, 10);
            this.add(new JLabel(labels[i]), c);
            c.anchor = GridBagConstraints.LINE_START; c.gridx = 1;
            this.add(components[i], c);
        }

        c.gridx = 1; c.gridy = 4;
        addButton = new AddButton(new AddListener(this, table, balance));
        this.add(addButton, c);
    }

    public String getType() {
        return (String) type.getSelectedItem();
    }

    public String getDescription() {
        return description.getText();
    }

    public double getAmount() {
        return Double.parseDouble(amount.getText().replace(",", "."));
    }

    public Date getDatetime() {
        return (Date) datetime.getValue();
    }

    public void clear() {
        datetime.setValue(new Date());
        description.setText("");
        amount.setText("");
    }
}