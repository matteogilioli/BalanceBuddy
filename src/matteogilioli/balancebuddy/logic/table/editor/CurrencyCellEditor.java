package matteogilioli.balancebuddy.logic.table.editor;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Classe che implementa un editor per le celle della tabella che contengono valori monetari.
 * L'editor è un {@link JFormattedTextField} con un {@link NumberFormatter} che formatta i valori in modo da mostrare solo due cifre decimali.
 * L'editor non mostra il simbolo della valuta, per facilitare la modifica del valore.
 */
public class CurrencyCellEditor extends DefaultCellEditor {
    /**
     * Campo di testo per l'editor.
     */
    private final JFormattedTextField doubleEditor;

    /**
     * Costruttore della classe.
     * Imposta il {@link JFormattedTextField} come editor (allineato a destra) e lo formatta con un {@link NumberFormatter}.
     * Il {@link NumberFormatter} formatta i valori in modo da mostrare solo due cifre decimali.
     */
    public CurrencyCellEditor() {
        super(new JFormattedTextField());
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        doubleEditor = (JFormattedTextField) getComponent();
        doubleEditor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(nf)));
        doubleEditor.setHorizontalAlignment(JFormattedTextField.RIGHT);
    }

    /**
     * @return il componente editor ({@link JFormattedTextField#getComponent(int)}).
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        doubleEditor.setValue(value);
        return doubleEditor;
    }

    /**
     * @return il valore dell'editor.
     */
    @Override
    public Object getCellEditorValue() {
        return doubleEditor.getValue();
    }
}
