package matteogilioli.balancebuddy.gui.table.logic;

import matteogilioli.balancebuddy.gui.table.BalanceTableModel;
import matteogilioli.balancebuddy.logic.BalanceEntry;
import matteogilioli.balancebuddy.logic.ExpenseEntry;
import matteogilioli.balancebuddy.logic.IncomeEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class BalanceTableCellRenderer extends DefaultTableCellRenderer {
    private static final Color expenseColor = new Color(255, 121, 97);
    private static final Color incomeColor = new Color(128, 226, 126);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        BalanceTableModel model = (BalanceTableModel) table.getModel();
        BalanceEntry entry = model.getEntries().get(row);

        if (!isSelected) {
            if (entry instanceof ExpenseEntry)
                c.setBackground(expenseColor);
            else if (entry instanceof IncomeEntry)
                c.setBackground(incomeColor);
        }

        return c;
    }
}