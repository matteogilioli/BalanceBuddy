package matteogilioli.balancebuddy.gui.components;

import javax.swing.*;

/**
 * Un {@link JSpinner} che permette di selezionare una data, con un formato personalizzato.
 */
public class SpinnerDate extends JSpinner {

    /**
     * Costruttore che inizializza il {@link JSpinner} con il modello {@link SpinnerDateModel}.
     * Imposta il formato della data in base al pattern specificato in input.
     * @param dateFormatPattern il pattern da utilizzare per formattare la data
     */
    public SpinnerDate(String dateFormatPattern) {
        super(new SpinnerDateModel());
        DateEditor dateEditor = new DateEditor(this, dateFormatPattern);
        this.setEditor(dateEditor);
    }
}
