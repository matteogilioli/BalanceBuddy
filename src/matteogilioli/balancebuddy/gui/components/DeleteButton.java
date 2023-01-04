package matteogilioli.balancebuddy.gui.components;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DeleteButton extends JButton {
    private static final ImageIcon deleteIcon = new ImageIcon("resources/delete.png");

    public DeleteButton(ActionListener onDeleteButtonClick) {
        super("Elimina selezionati", deleteIcon);
        this.addActionListener(onDeleteButtonClick);
    }
}
