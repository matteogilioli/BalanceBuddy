package matteogilioli.balancebuddy.gui.table.logic;

import matteogilioli.balancebuddy.gui.logic.LocaleNumberFormatFactory;

import javax.swing.*;
import java.awt.*;

public class CurrencyCellEditor extends DefaultCellEditor {
    private final JFormattedTextField doubleEditor;

    public CurrencyCellEditor() {
        super(new JFormattedTextField());
        doubleEditor = (JFormattedTextField) getComponent();
        doubleEditor.setFormatterFactory(new LocaleNumberFormatFactory());
        doubleEditor.setHorizontalAlignment(JFormattedTextField.RIGHT);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        doubleEditor.setValue(value);
        return doubleEditor;
    }

    @Override
    public Object getCellEditorValue() {
        return doubleEditor.getValue();
    }
}
