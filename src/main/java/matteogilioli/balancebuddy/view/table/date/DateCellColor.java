package matteogilioli.balancebuddy.view.table.date;

import matteogilioli.balancebuddy.view.table.CellColor;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateCellColor extends CellColor {
    private final DateTimeFormatter formatter;

    public DateCellColor() {
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }

    @Override
    public void setValue(Object value) {
        setText(((LocalDateTime) value).format(formatter));
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}