package matteogilioli.balancebuddy.logic.table.editor;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class CurrencyCellEditor extends DefaultCellEditor {
    private final JFormattedTextField doubleEditor;

    public CurrencyCellEditor() {
        super(new JFormattedTextField());
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        doubleEditor = (JFormattedTextField) getComponent();
        doubleEditor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(nf)));
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
