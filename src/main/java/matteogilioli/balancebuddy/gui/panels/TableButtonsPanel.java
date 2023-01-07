package matteogilioli.balancebuddy.gui.panels;

import matteogilioli.balancebuddy.gui.components.DeleteButton;
import matteogilioli.balancebuddy.gui.components.EditButton;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TableButtonsPanel extends JPanel {
    private final EditButton editButton;
    private final DeleteButton deleteButton;

    public TableButtonsPanel(TablePanel table, ActionListener deleteListener, ActionListener editListener) {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        deleteButton = new DeleteButton(deleteListener);
        editButton = new EditButton(editListener);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(editButton);

        this.add(table);
        this.add(buttonsPanel);
    }
}
