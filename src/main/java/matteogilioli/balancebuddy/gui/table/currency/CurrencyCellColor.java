package matteogilioli.balancebuddy.gui.table.currency;

import matteogilioli.balancebuddy.gui.table.CellColor;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyCellColor extends CellColor {
    private final NumberFormat formatter;

    public CurrencyCellColor() {
        formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        this.setHorizontalAlignment(JLabel.RIGHT);
    }

    @Override
    public void setValue(Object value) {
        setText(formatter.format(value));
    }
}
