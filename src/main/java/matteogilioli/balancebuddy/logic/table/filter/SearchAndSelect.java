package matteogilioli.balancebuddy.logic.table.filter;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class SearchAndSelect {
    private final ArrayList<Integer> matches = new ArrayList<>();
    private final JTable table;
    private int currentMatch = 0;

    public SearchAndSelect(JTable table, String searchText, int searchColumn) {
        this.table = table;

        TableModel model = table.getModel();
        for (int row = 0; row < table.getRowCount(); row++) {
            int modelRow = table.convertRowIndexToModel(row);
            Object value = model.getValueAt(modelRow, searchColumn);
            if (value.toString().toLowerCase().contains(searchText.toLowerCase()))
                matches.add(row);
        }
    }

    public void searchAndSelect() {
        if (matches.size() > 0) {
            int row = matches.get(currentMatch);
            table.setRowSelectionInterval(row, row);
            table.scrollRectToVisible(table.getCellRect(row, 0, true));
            currentMatch = (currentMatch + 1) % matches.size();
        } else {
            table.clearSelection();
        }
    }
}
