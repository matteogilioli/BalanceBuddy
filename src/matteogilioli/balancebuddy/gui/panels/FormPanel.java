package matteogilioli.balancebuddy.gui.panels;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class FormPanel extends JPanel {
    private static final String[] labels = {"Descrizione: ", "Importo: ", "Data: "};
    private static final int rows = labels.length;
    private static final int columns = 2;

    public FormPanel(ActionListener addListener) {
        super();

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < rows; i++) {
            c.gridy = i;
            for (int j = 0; j < columns; j++) {
                c.gridx = j;
                if (j == 0) { // Labels
                    c.insets = new Insets(5, 0, 0, 10);
                    c.anchor = GridBagConstraints.LINE_END;
                    this.add(new JLabel(labels[i]), c);
                } else if (i == 2) { // Date picker
                    Date today = new Date();
                    JSpinner spinner = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.MONTH));
                    JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yy");
                    spinner.setEditor(editor);
                    c.anchor = GridBagConstraints.LINE_START;
                    this.add(spinner, c);
                } else { // Text fields
                    c.anchor = GridBagConstraints.LINE_START;
                    this.add(new JTextField(15), c);
                }
            }
        }

        ImageIcon addIcon = new ImageIcon("resources/add.png");
        JButton addButton = new JButton("Aggiungi / Modifica", addIcon);
        addButton.addActionListener(addListener);
        c.gridx = 1;
        c.gridy = 3;
        this.add(addButton, c);
    }
}
