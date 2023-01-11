package matteogilioli.balancebuddy.gui.table.logic;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyCellRenderer extends BalanceTableCellRenderer {
    private NumberFormat formatter;

    public CurrencyCellRenderer() {
        formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        this.setHorizontalAlignment(JLabel.RIGHT);
    }

    @Override
    public void setValue(Object value) {
        setText(formatter.format(value));
    }
}
