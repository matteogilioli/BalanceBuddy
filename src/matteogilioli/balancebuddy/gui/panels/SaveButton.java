package matteogilioli.balancebuddy.gui.panels;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SaveButton extends JPanel {
    public SaveButton(ActionListener onSaveButtonClick) {
        super();
        ImageIcon addIcon = new ImageIcon("resources/add.png");
        JButton addButton = new JButton("Aggiungi / Modifica", addIcon);
        addButton.addActionListener(onSaveButtonClick);
        this.add(addButton);
    }
}
