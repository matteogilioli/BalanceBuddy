package matteogilioli.balancebuddy.gui.table.renderer;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Classe che estende {@link CellColor} per renderizzare le celle della tabella
 * corrispondenti a valori monetari, in modo da aggiungere il simbolo della valuta.
 */
public class CurrencyCellColor extends CellColor {
    /**
     * Il formato utilizzato per formattare i valori monetari.
     */
    private final NumberFormat formatter;

    /**
     * Costruttore che inizializza {@link #formatter} con il formato monetario di default,
     * imposta anche l'allineamento del testo a destra.
     */
    public CurrencyCellColor() {
        formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        this.setHorizontalAlignment(JLabel.RIGHT);
    }

    /**
     * Formatta il valore monetario in input, e lo imposta.
     * @param value il valore monetario da formattare
     */
    @Override
    public void setValue(Object value) {
        setText(formatter.format(value));
    }
}
