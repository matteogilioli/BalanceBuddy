package matteogilioli.balancebuddy.gui.components.buttons;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddButton extends JButton {
    private static final FontIcon icon = FontIcon.of(FontAwesomeSolid.PLUS, 16, new Color(0, 153, 51));

    public AddButton(ActionListener onDeleteButtonClick) {
        super("Aggiungi", icon);
        this.addActionListener(onDeleteButtonClick);
        this.setPreferredSize(new Dimension(180, 35));
    }
}
