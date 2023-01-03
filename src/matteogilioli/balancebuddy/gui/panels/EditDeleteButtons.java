package matteogilioli.balancebuddy.gui.panels;

import javax.swing.*;
import java.awt.event.ActionListener;

public final class EditDeleteButtons extends JPanel {
    public EditDeleteButtons(ActionListener onDeleteButtonClick, ActionListener onEditButtonClick) {
        super();

        ImageIcon deleteIcon = new ImageIcon("resources/delete.png");
        JButton deleteButton = new JButton("Elimina selezionati", deleteIcon);
        deleteButton.addActionListener(onDeleteButtonClick);
        this.add(deleteButton);

        this.add(Box.createHorizontalStrut(8));

        ImageIcon editIcon = new ImageIcon("resources/edit.png");
        JButton editButton = new JButton("Modifica selezionati", editIcon);
        editButton.addActionListener(onEditButtonClick);
        this.add(editButton);
    }
}
