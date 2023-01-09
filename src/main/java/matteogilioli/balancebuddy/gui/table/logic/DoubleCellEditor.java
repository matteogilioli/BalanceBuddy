package matteogilioli.balancebuddy.gui.table.logic;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class DoubleCellEditor extends DefaultCellEditor {
    private final JFormattedTextField doubleEditor;

    public DoubleCellEditor() {
        super(new JTextField());
        NumberFormat doubleFormat = NumberFormat.getNumberInstance();
        doubleFormat.setMinimumFractionDigits(2);
        doubleEditor = new JFormattedTextField(doubleFormat);
        doubleEditor.setHorizontalAlignment(JFormattedTextField.RIGHT);
    }

    @Override
    public Object getCellEditorValue() {
        return doubleEditor.getValue();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        doubleEditor.setValue(value);
        return doubleEditor;
    }
}
