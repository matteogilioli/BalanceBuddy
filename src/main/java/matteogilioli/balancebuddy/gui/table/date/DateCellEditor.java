package matteogilioli.balancebuddy.gui.table.date;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateCellEditor extends DefaultCellEditor {
    private final JSpinner spinner;

    public DateCellEditor() {
        super(new JTextField());
        spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy HH:mm");
        dateEditor.getTextField().setHorizontalAlignment(JTextField.RIGHT);
        spinner.setEditor(dateEditor);
    }

    @Override
    public Object getCellEditorValue() {
        return spinner.getValue();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        spinner.setValue(Timestamp.valueOf((LocalDateTime) value));
        return spinner;
    }
}