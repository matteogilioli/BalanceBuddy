package matteogilioli.balancebuddy.gui.components;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Il {@link JButton} per aggiungere un movimento.
 */
public class AddButton extends JButton {
    /**
     * Icona del {@link JButton}.
     */
    private static final FontIcon icon = FontIcon.of(FontAwesomeSolid.PLUS, 16, new Color(0, 153, 51));

    /**
     * Costruttore che inizializza il {@link JButton} con l'icona e il nome.
     *
     * @param onAddButtonClick l'{@link ActionListener} che gestisce il click sul {@link JButton}
     */
    public AddButton(ActionListener onAddButtonClick) {
        super("Aggiungi", icon);
        this.addActionListener(onAddButtonClick);
        this.setPreferredSize(new Dimension(180, 35));
    }
}
