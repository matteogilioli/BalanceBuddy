package matteogilioli.balancebuddy.gui;

import matteogilioli.balancebuddy.gui.components.AddButton;
import matteogilioli.balancebuddy.gui.components.SpinnerDate;
import matteogilioli.balancebuddy.logic.Utility;
import matteogilioli.balancebuddy.logic.actions.buttonsListener.AddListener;
import matteogilioli.balancebuddy.logic.formatter.LocalePositiveNumberFormat;
import matteogilioli.balancebuddy.logic.table.BalanceTableModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

/**
 * La finestra di dialogo che permette di aggiungere un movimento.
 */
public class FormDialog extends JDialog {
    /**
     * I nomi delle {@link JLabel} affiancate ai campi da inserire.
     */
    private static final String[] labels = {"Tipo", "Data", "Descrizione", "Importo"};

    /**
     * Permette di selezionare il tipo di movimento (Entrata o Uscita).
     */
    private final JComboBox<String> type;

    /**
     * Campo di testo per inserire la descrizione del movimento.
     */
    private final JTextField description;

    /**
     * Campo di testo per inserire l'importo del movimento.
     */
    private final JFormattedTextField amount;

    /**
     * Permette di selezionare la data e l'ora del movimento.
     */
    private final JSpinner datetime;

    /**
     * Bottone per confermare l'inserimento del movimento.
     */
    public final JButton addButton;

    /**
     * Costruttore che inizializza i campi e {#link #addButton}.
     * @param entryType il tipo di movimento da aggiungere (può essere cambiato in seguito)
     * @param tableModel il modello della tabella che dovrà essere aggiornato
     */
    public FormDialog(String entryType, BalanceTableModel tableModel) {
        super();

        type = new JComboBox<>("Entrata, Uscita".split(", "));
        type.addItemListener(e -> changeType((String) e.getItem()));
        description = new JTextField();
        amount = new JFormattedTextField(new LocalePositiveNumberFormat());
        datetime = new SpinnerDate("dd/MM/yyyy HH:mm");
        addButton = new AddButton(new AddListener(this, tableModel));

        changeType(entryType);

        createGUI();
    }

    /**
     * Crea la finestra di dialogo e posiziona i componenti graficamente.
     */
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

    /**
     * @return il tipo di movimento selezionato (Entrata o Uscita)
     */
    public String getSelectedType() {
        return (String) type.getSelectedItem();
    }

    /**
     * @return la descrizione del movimento inserita
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * @return l'importo del movimento inserito
     */
    public String getAmount() {
        return amount.getText();
    }

    /**
     * @return la data e l'ora del movimento inseriti
     */
    public LocalDateTime getDatetime() {
        return Utility.getDateTime(datetime);
    }

    /**
     * Cambia il tipo di movimento da aggiungere.
     * @param entryType il tipo di movimento (Entrata o Uscita)
     * @throws IllegalStateException se il tipo di movimento non è valido
     */
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

    /**
     * Mostra un {@link JOptionPane} per indicare un errore.
     * @param error il messaggio di errore
     */
    public void setError(String error) {
        JOptionPane.showMessageDialog(this, error, "Creazione fallita", JOptionPane.ERROR_MESSAGE);
    }
}