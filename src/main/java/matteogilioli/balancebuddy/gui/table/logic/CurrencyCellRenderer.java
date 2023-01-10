package matteogilioli.balancebuddy.gui.table.logic;

import javax.swing.*;
import java.text.NumberFormat;

public class CurrencyCellRenderer extends BalanceTableCellRenderer {
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
