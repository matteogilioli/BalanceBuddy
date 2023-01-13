package matteogilioli.balancebuddy.view.components;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteButton extends JButton {
    private static final FontIcon icon = FontIcon.of(FontAwesomeSolid.TRASH_ALT, 16, Color.RED);

    public DeleteButton(ActionListener onDeleteButtonClick) {
        super("Elimina selezionati", icon);
        this.addActionListener(onDeleteButtonClick);
        this.setPreferredSize(new Dimension(180, 35));
    }
}
