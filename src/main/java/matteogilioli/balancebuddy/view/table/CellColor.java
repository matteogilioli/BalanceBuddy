package matteogilioli.balancebuddy.view.table;

import matteogilioli.balancebuddy.controller.table.BalanceTableModel;
import matteogilioli.balancebuddy.model.BalanceEntry;
import matteogilioli.balancebuddy.model.ExpenseEntry;
import matteogilioli.balancebuddy.model.IncomeEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CellColor extends DefaultTableCellRenderer {
    private static final Color expenseColor = new Color(255, 97, 72, 150);
    private static final Color incomeColor = new Color(128, 226, 126, 150);
    private static final Color selectionColor = new Color(40, 100, 228);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        BalanceTableModel model = (BalanceTableModel) table.getModel();
        BalanceEntry entry = model.getEntries().get(table.convertRowIndexToModel(row));

        setBorder(noFocusBorder);

        if (isSelected) {
            c.setBackground(selectionColor);
            c.setForeground(Color.WHITE);
        } else {
            c.setForeground(Color.BLACK);
            if (entry instanceof ExpenseEntry)
                c.setBackground(expenseColor);
            else if (entry instanceof IncomeEntry)
                c.setBackground(incomeColor);
        }

        return c;
    }
}