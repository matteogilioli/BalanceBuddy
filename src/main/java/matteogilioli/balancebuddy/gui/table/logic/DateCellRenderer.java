package matteogilioli.balancebuddy.gui.table.logic;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateCellRenderer extends BalanceTableCellRenderer {
    private final DateTimeFormatter formatter;

    public DateCellRenderer() {
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }

    @Override
    public void setValue(Object value) {
        setText(((LocalDateTime) value).format(formatter));
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}