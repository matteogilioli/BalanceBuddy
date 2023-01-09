package matteogilioli.balancebuddy.gui.logic;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCellRenderer extends DefaultTableCellRenderer {
    private final DateFormat formatter;

    public DateCellRenderer() {
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value instanceof Date) {
            setText(formatter.format((Date) value));
            this.setHorizontalAlignment(JLabel.CENTER);
        }

        return this;
    }
}