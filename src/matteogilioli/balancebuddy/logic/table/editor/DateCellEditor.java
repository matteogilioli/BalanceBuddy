package matteogilioli.balancebuddy.logic.table.editor;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Classe che rappresenta un editor di celle per la data e l'ora.
 */
public class DateCellEditor extends DefaultCellEditor {
    /**
     * JSpinner utilizzato per l'editor.
     */
    private final JSpinner spinner;

    /**
     * Costruttore della classe.
     * Imposta il {@link JSpinner} come editor (allineato a destra) e lo formatta con un {@link SpinnerDateModel}.
     */
    public DateCellEditor() {
        super(new JTextField());
        spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy HH:mm");
        dateEditor.getTextField().setHorizontalAlignment(JTextField.RIGHT);
        spinner.setEditor(dateEditor);
    }

    /**
     * @return il componente editor ({@link JSpinner}).
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        spinner.setValue(Timestamp.valueOf((LocalDateTime) value));
        return spinner;
    }

    /**
     * @return il valore dell'editor.
     */
    @Override
    public Object getCellEditorValue() {
        return spinner.getValue();
    }
}