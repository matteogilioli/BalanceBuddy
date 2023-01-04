package matteogilioli.balancebuddy.gui.components;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AddButton extends JButton {
    private static final ImageIcon addIcon = new ImageIcon("resources/add.png");

    public AddButton(ActionListener onAddButtonClick) {
        super("Aggiungi / Modifica", addIcon);
        this.addActionListener(onAddButtonClick);
    }
}

