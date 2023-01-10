package matteogilioli.balancebuddy.gui.table.logic;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCellRenderer extends BalanceTableCellRenderer {
    private final DateFormat formatter;

    public DateCellRenderer() {
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    }

    @Override
    public void setValue(Object value) {
        setText(formatter.format((Date) value));
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}