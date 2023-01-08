package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.AddButton;
import matteogilioli.balancebuddy.gui.components.CurrencyFilter;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class FormPanel extends JPanel {
    private static final String[] labels = {"Tipo", "Descrizione", "Importo", "Data"};
    private static final int rows = labels.length;
    private final AddButton addButton;
    private final JComboBox<String> type = new JComboBox<>("Entrata, Uscita".split(", "));
    private final JTextField description = new JTextField();
    private final JTextField amount = new JTextField();
    private final JSpinner datetime = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.MONTH));

    public FormPanel(ActionListener addListener) {
        super();

        type.setPreferredSize(new Dimension(180, 30));
        description.setPreferredSize(new Dimension(180, 30));
        amount.setPreferredSize(new Dimension(180, 30));
        datetime.setPreferredSize(new Dimension(180, 30));

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        AbstractDocument doc = (AbstractDocument) amount.getDocument();
        doc.setDocumentFilter(new CurrencyFilter());

        JComponent[] components = {type, description, amount, datetime};

        for (int i = 0; i < rows; i++) {
            c.anchor = GridBagConstraints.LINE_END; c.gridx = 0; c.gridy = i;
            c.insets = new Insets(5, 0, 0, 10);
            this.add(new JLabel(labels[i]), c);
            c.anchor = GridBagConstraints.LINE_START; c.gridx = 1;
            this.add(components[i], c);
        }

        c.gridx = 1; c.gridy = 4;
        addButton = new AddButton(addListener);
        this.add(addButton, c);
    }

    public String getType() {
        return (String) type.getSelectedItem();
    }

    public String getDescription() {
        return description.getText();
    }

    public double getAmount() {
        return Double.parseDouble(amount.getText());
    }

    public LocalDateTime getDatetime() {
        Date date = (Date) datetime.getValue();
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public void clear() {
        description.setText("");
        amount.setText("");
        datetime.setValue(new Date());
    }
}