package matteogilioli.balancebuddy.gui.panels;

import javax.swing.*;
import java.awt.event.ActionListener;

public final class ButtonsPanel extends JPanel {
    public ButtonsPanel(ActionListener onDeleteButtonClick, ActionListener onAddButtonClick) {
        super();

        this.add(Box.createHorizontalStrut(8));

        ImageIcon deleteIcon = new ImageIcon("resources/delete.png");
        JButton deleteButton = new JButton("Elimina selezionati", deleteIcon);
        deleteButton.addActionListener(onDeleteButtonClick);
        this.add(deleteButton);

        this.add(Box.createHorizontalStrut(8));

        ImageIcon addIcon = new ImageIcon("resources/add.png");
        JButton addButton = new JButton("Aggiungi voce", addIcon);
        addButton.addActionListener(onAddButtonClick);
        this.add(addButton);

        this.add(Box.createHorizontalStrut(8));
    }
}
