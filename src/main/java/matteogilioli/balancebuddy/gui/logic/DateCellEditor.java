package matteogilioli.balancebuddy.gui.logic;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

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
        spinner.setValue((Date) value);
        return spinner;
    }
}