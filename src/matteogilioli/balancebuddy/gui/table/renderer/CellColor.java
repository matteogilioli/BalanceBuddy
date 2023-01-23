package matteogilioli.balancebuddy.gui.table.renderer;

import matteogilioli.balancebuddy.logic.model.Balance;
import matteogilioli.balancebuddy.logic.model.BalanceEntry;
import matteogilioli.balancebuddy.logic.model.ExpenseEntry;
import matteogilioli.balancebuddy.logic.model.IncomeEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Classe che estende {@link DefaultTableCellRenderer} per cambiare il colore delle celle della tabella,
 * in base al tipo di {@link BalanceEntry voce di bilancio}.
 */
public class CellColor extends DefaultTableCellRenderer {
    /**
     * Colore per le celle che rappresentano una {@link ExpenseEntry spesa}.
     */
    private static final Color expenseColor = new Color(255, 97, 72, 150);

    /**
     * Colore per le celle che rappresentano un'{@link ExpenseEntry entrata}.
     */
    private static final Color incomeColor = new Color(128, 226, 126, 150);

    /**
     * Colore per le celle selezionate.
     */
    private static final Color selectionColor = new Color(40, 100, 228);

    /**
     * Applica il colore alle celle della tabella, in base al tipo di {@link BalanceEntry voce di bilancio};
     * se la cella è selezionata, viene applicato un colore diverso.
     *
     * @param table la tabella
     * @param value il valore della cella
     * @param isSelected se la cella è selezionata
     * @param hasFocus se la cella ha il focus
     * @param row la riga della cella
     * @param column la colonna della cella
     * @return il componente della cella
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        BalanceEntry entry = Balance.getEntries().get(table.convertRowIndexToModel(row));

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