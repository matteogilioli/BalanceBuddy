package matteogilioli.balancebuddy.gui.logic;

import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class CurrencyCellRenderer extends DefaultTableCellRenderer {
    private NumberFormat formatter;

    public CurrencyCellRenderer() {
        formatter = NumberFormat.getCurrencyInstance();
        this.setHorizontalAlignment(JLabel.RIGHT);
    }

    @Override
    public void setValue(Object value) {
        setText(formatter.format(value));
    }
}
