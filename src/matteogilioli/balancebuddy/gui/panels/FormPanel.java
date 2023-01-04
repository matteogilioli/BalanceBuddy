package matteogilioli.balancebuddy.gui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

public class FormPanel extends JPanel {
    private static final String[] labels = {"Descrizione: ", "Importo: ", "Data: "};
    private static final int rows = labels.length;
    private final JTextField description = new JTextField(15);
    private final JFormattedTextField amount = new JFormattedTextField(NumberFormat.getCurrencyInstance());
    private final JSpinner datetime = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.MONTH));

    public FormPanel(ActionListener addListener) {
        super();

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        amount.setColumns((15));
        JComponent[] components = {description, amount, datetime};

        for (int i = 0; i < rows; i++) {
            c.anchor = GridBagConstraints.LINE_END; c.gridx = 0; c.gridy = i;
            c.insets = new Insets(5, 0, 0, 10);
            this.add(new JLabel(labels[i]), c);
            c.anchor = GridBagConstraints.LINE_START; c.gridx = 1;
            this.add(components[i], c);
        }

        ImageIcon addIcon = new ImageIcon("resources/add.png");
        JButton addButton = new JButton("Aggiungi / Modifica", addIcon);
        addButton.addActionListener(addListener);
        c.gridx = 1; c.gridy = 3;
        this.add(addButton, c);
    }
}