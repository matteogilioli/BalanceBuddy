package matteogilioli.balancebuddy.gui.components;

import javax.swing.*;
import java.awt.event.ActionListener;

public class EditButton extends JButton {
    private static final ImageIcon editIcon = new ImageIcon("resources/edit.png");

    public EditButton(ActionListener onEditButtonClick) {
        super("Modifica selezionati", editIcon);
        this.addActionListener(onEditButtonClick);
    }
}
