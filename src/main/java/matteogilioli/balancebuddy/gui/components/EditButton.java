package matteogilioli.balancebuddy.gui.components;

import org.kordamp.ikonli.fontawesome5.FontAwesomeRegular;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditButton extends JButton {
    private static final FontIcon icon = FontIcon.of(FontAwesomeSolid.EDIT, 16, new Color(255, 153, 51));

    public EditButton(ActionListener onDeleteButtonClick) {
        super("Modifica selezionati", icon);
        this.addActionListener(onDeleteButtonClick);
        this.setPreferredSize(new Dimension(180, 35));
    }
}
