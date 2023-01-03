package matteogilioli.balancebuddy.gui.panels;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TableButtonsPanel extends JPanel {
    private final EditDeleteButtons editDeleteButtons;

    public TableButtonsPanel(Table table, ActionListener onDeleteButtonClick, ActionListener onEditButtonClick) {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        editDeleteButtons = new EditDeleteButtons(onDeleteButtonClick, onEditButtonClick);

        this.add(table);
        this.add(editDeleteButtons);
    }
}
